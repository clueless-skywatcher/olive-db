package io.db.olive.sql.ddl;

import java.util.Map;

import io.db.olive.OLDatabase;
import io.db.olive.OLParsingMachine;
import io.db.olive.OLUtils;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import io.db.olive.tuples.OLTupleSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLCreateTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private Map<String, OLDataInfo> columnMap;
    private @Getter OLSQLResult result;
    private OLTupleSchema schema;
    private String query;

    public OLCreateTableSQL(String tableName, Map<String, OLDataInfo> columnMap, String query) {
        this.tableName = tableName;
        this.columnMap = columnMap;
        this.schema = new OLTupleSchema();
        for (Map.Entry<String, OLDataInfo> entry : columnMap.entrySet()) {
            this.schema.addField(entry.getKey(), entry.getValue());
        }
        this.query = query;
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        if (database.exists(tableName)) {
            throw new Exception(String.format("Tablename %s already exists", tableName));
        }
        
        database.createTableFile(tableName, schema);

        if (!OLUtils.isMetaTable(tableName)) {
            addOlTablesEntry(database, bufferPool);
            addOlAttributesEntries(database, bufferPool);
        }
    }

    private void addOlTablesEntry(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        String addOlTablesEntry = String.format(
                "insert into ol_tables (tablename, catalogname, tuplesize) values ('%s', 'public', %d);",
                tableName,
                schema.getSize());
        OLParsingMachine.parse(addOlTablesEntry).execute(database, bufferPool);
    }

    private void addOlAttributesEntries(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        for (String field : schema.getFields()) {
            OLDataInfo info = schema.getInfo(field);
            String addOlAttributesEntry = String.format(
                    "insert into ol_attributes (columnname, tablename, datatype, datasize) values ('%s', '%s', '%s', %d);",
                    field,
                    tableName,
                    info.getSQLTypeName(),
                    info.getMaxSize());
            OLParsingMachine.parse(addOlAttributesEntry).execute(database, bufferPool);
            ;
        }
    }

    public String toString() {
        return query;
    }
}
