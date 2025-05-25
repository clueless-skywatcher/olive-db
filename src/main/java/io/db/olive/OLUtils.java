package io.db.olive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.db.olive.metatables.OLAttributesMetaTable;
import io.db.olive.metatables.OLMetaTable;
import io.db.olive.metatables.OLTablesMetaTable;
import io.db.olive.tuples.OLTupleSchema;

public class OLUtils {
    public static Map<String, OLMetaTable> metaTableList = new HashMap<>();

    static {
        metaTableList.put("ol_tables", new OLTablesMetaTable());
        metaTableList.put("ol_attributes", new OLAttributesMetaTable());
    }   

    static List<String> metaTables = List.of(
        new OLAttributesMetaTable().getName(),
        new OLTablesMetaTable().getName()
    );

    public static boolean isMetaTable(String tableName) {
        return metaTableList.containsKey(tableName);
    }

    public static OLTupleSchema getMetaTableSchema(String tableName) {
        return metaTableList.get(tableName).getSchema();
    }
}
