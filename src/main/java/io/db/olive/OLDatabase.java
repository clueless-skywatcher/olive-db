package io.db.olive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLStorageManager;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLDatabase {
    private @Getter OLStorageManager storageManager;
    private @Getter OLOptions options;
    private @Getter String dbName;
    private Map<String, OLTupleSchema> schema;
    
    public OLDatabase(String dbName, OLOptions options) throws Exception {
        this.options = options;
        this.storageManager = new OLStorageManager(dbName, this.options);
        this.schema = new HashMap<>();
    }

    public OLDataFile createTableFile(String tableName, OLTupleSchema schema) throws Exception {
        this.schema.put(tableName, schema);
        return this.storageManager.startTableFile(tableName, schema);
    }

    public OLDataFile getTableFile(String tableName) throws Exception {
        return this.storageManager.startTableFile(tableName, schema.get(tableName));
    }

    public void dropDatabase() throws Exception {
        this.storageManager.dropDatabase();
    }

    public List<OLTuple> selectAllTuples(String tableName, OLTupleSchema schema, OLBufferPool pool) throws Exception {
        return this.storageManager.selectAllTuples(tableName, schema, pool);
    }

    public void insertTuple(String tableName, OLTuple tuple, OLBufferPool pool) throws Exception {
        this.storageManager.insertTuple(tableName, tuple, pool);
    }

    public OLTupleSchema getSchema(String tableName) {
        return this.schema.get(tableName);
    }
}
