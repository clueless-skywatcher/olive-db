package io.db.olive;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.metatables.OLMetaTable;
import io.db.olive.sql.OLSQLBase;

public class OLDBInitializer {
    public static OLDatabase initialize(String dbName, OLOptions options, OLBufferPool bufferPool) throws Exception {
        OLDatabase metaDatabase = new OLDatabase(dbName, options, bufferPool);

        for (OLMetaTable metaTable: OLUtils.metaTableList.values()) {
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
        for (OLMetaTable metaTable: OLUtils.metaTableList.values()) {
            OLSQLBase addEntrySQL = OLParsingMachine.parse(
                String.format(
                    "insert into %s (%s) values ('%s', '%s', %d);",
                    OLUtils.metaTableList.get("ol_tables").getName(),
                    OLUtils.metaTableList.get("ol_tables").getSchema().getInsertionAttributeString(),
                    metaTable.getName(),
                    "catalog",
                    metaTable.getSchema().getSize()
                )
            );
            addEntrySQL.execute(database, bufferPool);
        }
    }

    private static void addOLAttributesEntries(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        for (OLMetaTable metaTable: OLUtils.metaTableList.values()) {
            for (String field: metaTable.getSchema().getFields()) {
                OLSQLBase insertEntrySQL = OLParsingMachine.parse(
                    String.format(
                        "insert into %s (%s) values ('%s', '%s', '%s', %d);",
                        OLUtils.metaTableList.get("ol_attributes").getName(),
                        OLUtils.metaTableList.get("ol_attributes").getSchema().getInsertionAttributeString(),
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
