package io.db.olive.metatables;

import io.db.olive.tuples.OLTupleSchema;

public interface OLMetaTable{
    public String getName();
    public OLTupleSchema getSchema();
}
