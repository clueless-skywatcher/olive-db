package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;

public class OLSelectionScan implements OLScan {
    private OLScan underlyingScan;

    public OLSelectionScan(OLScan underlyingScan) {
        this.underlyingScan = underlyingScan;
    }

    @Override
    public boolean hasNext() {
        return underlyingScan.hasNext();
    }

    @Override
    public OLTuple next() throws Exception {
        return underlyingScan.next();
    }    
}
