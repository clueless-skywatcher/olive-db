package io.db.olive;

import java.util.List;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLStorageManager;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLDatabase {
    private OLStorageManager storageManager;
    private OLOptions options;
    private @Getter String dbName;

    public OLDatabase(String dbName, OLOptions options) throws Exception {
        this.options = options;
        this.storageManager = new OLStorageManager(dbName, this.options);
    }

    public OLDataFile createTable(String tableName, OLTupleSchema schema) throws Exception {
        return this.storageManager.startTableFile(tableName, schema);
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
}
