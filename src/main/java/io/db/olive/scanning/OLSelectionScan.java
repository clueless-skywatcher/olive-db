package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLSelectionScan implements OLScan {
    private OLScan underlyingScan;
    private @Getter OLTupleSchema schema;

    public OLSelectionScan(OLScan underlyingScan) {
        this.underlyingScan = underlyingScan;
        this.schema = underlyingScan.getSchema();
    }

    @Override
    public boolean hasNext() {
        return underlyingScan.hasNext();
    }

    @Override
    public OLTuple next() throws Exception {
        return underlyingScan.next();
    }  
    
    public String toString() {
        return String.format("""
        SelectionScan
        ---> %s""", 
        underlyingScan.toString());
    }
}
