package io.db.olive.scanning;

import java.util.Collections;
import java.util.List;

import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLInMemorySortingScan implements OLScan {
    private int index = 0;
    private List<OLTuple> tuples;
    private @Getter OLTupleSchema schema;
    private List<String> sortFields;
    private OLScanComparator comparator;
    private boolean descending;

    public OLInMemorySortingScan(List<OLTuple> tuples, List<String> sortFields, boolean descending) {
        this.tuples = tuples;
        this.schema = tuples.get(0).getSchema();
        this.sortFields = sortFields;
        this.comparator = new OLScanComparator(sortFields);
        this.descending = descending;

        sort();
    }

    private void sort() {
        Collections.sort(
            tuples, (t1, t2) -> comparator.compare(t1, t2, descending)
        );
    }

    @Override
    public boolean hasNext() throws Exception {
        return index < tuples.size();
    }

    @Override
    public void next() throws Exception {
        index++;
    }

    @Override
    public OLTuple getCurrentRow() throws Exception {
        return tuples.get(index);
    }

    @Override
    public void rewind() throws Exception {
        index = 0;
    }

    @Override
    public String toString(String indent) {
        return "";
    }
    
}
