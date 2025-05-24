package io.db.olive;

import java.util.List;

import io.db.olive.metatables.OLAttributesMetaTable;
import io.db.olive.metatables.OLTablesMetaTable;

public class OLUtils {
    static List<String> metaTables = List.of(
        new OLAttributesMetaTable().getName(),
        new OLTablesMetaTable().getName()
    );

    public static boolean isMetaTable(String tableName) {
        return metaTables.contains(tableName);
    }
}
