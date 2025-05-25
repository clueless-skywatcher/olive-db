package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;

public interface OLWriteableScan extends OLScan {
    public void insert(OLTuple tuple);
}
