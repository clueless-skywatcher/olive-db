package io.db.olive;

import java.util.LinkedHashMap;
import java.util.Map;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLStorageManager;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLDatabase {
    private @Getter OLStorageManager storageManager;
    private @Getter OLOptions options;
    private @Getter String dbName;
    private Map<String, OLTupleSchema> schemaCache;
    private OLBufferPool bufferPool;
    
    public OLDatabase(String dbName, OLOptions options, OLBufferPool bufferPool) throws Exception {
        this.options = options;
        this.storageManager = new OLStorageManager(dbName, this.options);
        this.schemaCache = new LinkedHashMap<>();
        this.bufferPool = bufferPool;
    }

    public OLDataFile createTableFile(String tableName, OLTupleSchema schema) throws Exception {
        this.schemaCache.put(tableName, schema);
        return this.storageManager.startTableFile(tableName, schema);
    }

    public OLDataFile getTableFile(String tableName) throws Exception {
        return this.storageManager.startTableFile(tableName, schemaCache.get(tableName));
    }

    public void dropDatabase() throws Exception {
        this.storageManager.dropDatabase();
    }

    public void insertTuple(String tableName, OLTuple tuple) throws Exception {
        this.storageManager.insertTuple(tableName, tuple, bufferPool);
    }

    public OLTupleSchema getSchema(String tableName) throws Exception {
        if (!schemaCache.containsKey(tableName)) {
            if (OLUtils.isMetaTable(tableName)) {
                this.schemaCache.put(tableName, OLUtils.getMetaTableSchema(tableName));
            } else {
                OLSQLBase getAttributes = OLParsingMachine.parse(
                    "select * from ol_attributes;"
                );
                getAttributes.execute(this, bufferPool);
                OLTupleSchema schema = new OLTupleSchema();
                for (OLTuple tuple: getAttributes.getResult().getTuples()) {
                    if (tuple.getField("tablename").toString().equals(tableName)) {
                        String dataType = tuple.getField("datatype").toString();
                        String columnName = tuple.getField("columnname").toString();
                        OLDataInfo info = OLTupleSchema.inferTypeFromDataTypeString(dataType);
                        schema.addField(columnName, info);
                    }
                }
                this.schemaCache.put(tableName, schema);
            }
        }
        return this.schemaCache.get(tableName);
    }

    public boolean exists(String tableName) {
        return this.schemaCache.containsKey(tableName) 
            && this.schemaCache.get(tableName) != null
            && this.schemaCache.get(tableName).getFields().size() > 0;
    }
}
