package io.db.olive.planning.plans;

import java.util.ArrayList;
import java.util.List;

import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLInMemorySortingScan;
import io.db.olive.tuples.OLTuple;

public class OLSortingPlan implements OLPlan {
    private OLPlan underlyingPlan;
    private int maxSortingMemory;
    private List<String> sortFields;
    private boolean descending;

    public OLSortingPlan(OLPlan underlyingPlan, int maxSortingMemory, List<String> sortFields, boolean descending) {
        this.underlyingPlan = underlyingPlan;
        this.maxSortingMemory = maxSortingMemory;
        this.sortFields = sortFields;
        this.descending = descending;
    }

    @Override
    public OLScan open() throws Exception {
        int memorySize = 0;
        List<OLTuple> tuples = new ArrayList<>();
        OLScan underlyingScan = underlyingPlan.open();
        while (underlyingScan.hasNext()) {
            OLTuple tuple = underlyingScan.getCurrentRow();
            if (tuple != null) {
                tuples.add(tuple);
                memorySize += tuple.getSchema().getSize();
            }
            underlyingScan.next();
        }

        if (memorySize < this.maxSortingMemory) {
            return new OLInMemorySortingScan(tuples, sortFields, descending);
        } else {
            // TODO: Implement external merge sort
            throw new Exception("Result too big to fit in sorting memory. Requires external merge sort");
        }
    }
    
}
