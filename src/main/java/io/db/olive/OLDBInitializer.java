package io.db.olive;

import java.util.HashMap;
import java.util.Map;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.metatables.OLAttributesMetaTable;
import io.db.olive.metatables.OLMetaTable;
import io.db.olive.metatables.OLTablesMetaTable;
import io.db.olive.sql.OLSQLBase;

public class OLDBInitializer {
    private static Map<String, OLMetaTable> metaTableList = new HashMap<>();

    static {
        metaTableList.put("ol_tables", new OLTablesMetaTable());
        metaTableList.put("ol_attributes", new OLAttributesMetaTable());
    }

    public static OLDatabase initialize(String dbName, OLOptions options, OLBufferPool bufferPool) throws Exception {
        OLDatabase metaDatabase = new OLDatabase(dbName, options);

        for (OLMetaTable metaTable: metaTableList.values()) {
            String olTableStatement = "create table %s (%s);";
            OLSQLBase createTableSQL = OLParsingMachine.parse(
                String.format(olTableStatement, metaTable.getName(), metaTable.getSchema().getCreateTableAttributeString())
            );
            createTableSQL.execute(metaDatabase, bufferPool);
        }

        addOLTablesEntries(metaDatabase, bufferPool);
        addOLAttributesEntries(metaDatabase, bufferPool);

        return metaDatabase;
    }

    private static void addOLTablesEntries(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        for (OLMetaTable metaTable: metaTableList.values()) {
            OLSQLBase addEntrySQL = OLParsingMachine.parse(
                String.format(
                    "insert into %s (%s) values ('%s', '%s', %d);",
                    metaTableList.get("ol_tables").getName(),
                    metaTableList.get("ol_tables").getSchema().getInsertionAttributeString(),
                    metaTable.getName(),
                    "catalog",
                    metaTable.getSchema().getSize()
                )
            );
            addEntrySQL.execute(database, bufferPool);
        }
    }

    private static void addOLAttributesEntries(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        for (OLMetaTable metaTable: metaTableList.values()) {
            for (String field: metaTable.getSchema().getFields()) {
                OLSQLBase insertEntrySQL = OLParsingMachine.parse(
                    String.format(
                        "insert into %s (%s) values ('%s', '%s', '%s', %d);",
                        metaTableList.get("ol_attributes").getName(),
                        metaTableList.get("ol_attributes").getSchema().getInsertionAttributeString(),
                        field,
                        metaTable.getName(),
                        metaTable.getSchema().getInfo(field).getSQLTypeName(),
                        metaTable.getSchema().getMaxSize(field)
                    )
                );
                insertEntrySQL.execute(database, bufferPool);
            }
        }
    }
}
