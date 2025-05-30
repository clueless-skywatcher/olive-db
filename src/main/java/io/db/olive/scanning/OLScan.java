package io.db.olive.scanning;

import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

public interface OLScan {
    public boolean hasNext() throws Exception;
    public void next() throws Exception;
    public OLTupleSchema getSchema();
    public OLTuple getCurrentRow() throws Exception;
    public void rewind() throws Exception;
    public String toString(String indent);
}
