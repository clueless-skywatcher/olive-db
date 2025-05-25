package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

public interface OLScan {
    public boolean hasNext();
    public OLTuple next() throws Exception;
    public OLTupleSchema getSchema();
}
