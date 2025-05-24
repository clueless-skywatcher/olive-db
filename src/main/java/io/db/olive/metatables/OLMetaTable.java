package io.db.olive.metatables;

import java.util.List;

import io.db.olive.tuples.OLTupleSchema;

public interface OLMetaTable{
    public String getName();
    public OLTupleSchema getSchema();
}
