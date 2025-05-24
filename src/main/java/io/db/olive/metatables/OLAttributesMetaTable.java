package io.db.olive.metatables;

import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLAttributesMetaTable implements OLMetaTable {
    private @Getter String name = "ol_attributes";
    private static OLTupleSchema SCHEMA = new OLTupleSchema();

    static {
        SCHEMA.addField("columnname", new OLCappedCharInfo(50));
        SCHEMA.addField("tablename", new OLCappedCharInfo(100));
        SCHEMA.addField("datatype", new OLCappedCharInfo(20));
        SCHEMA.addField("datasize", new OLIntegerInfo());
        // SCHEMA.addField("primarykey", new OLBooleanInfo());
    }

    public OLTupleSchema getSchema() {
        return SCHEMA;
    }
}
