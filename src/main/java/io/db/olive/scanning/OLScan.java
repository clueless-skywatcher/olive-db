package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;

public interface OLScan {
    public boolean hasNext();
    public OLTuple next() throws Exception;
}
