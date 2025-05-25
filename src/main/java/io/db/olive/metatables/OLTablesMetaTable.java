package io.db.olive.metatables;

import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLTablesMetaTable implements OLMetaTable {
    private @Getter String name = "ol_tables";
    private static OLTupleSchema SCHEMA = new OLTupleSchema();

    static {
        SCHEMA.addField("tablename", new OLCappedCharInfo(100));
        SCHEMA.addField("catalogname", new OLCappedCharInfo(20));
        SCHEMA.addField("tuplesize", new OLIntegerInfo());
    }

    public OLTupleSchema getSchema() {
        return SCHEMA;
    }
}
