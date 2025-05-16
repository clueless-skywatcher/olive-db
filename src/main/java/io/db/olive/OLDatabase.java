package io.db.olive;

import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLStorageManager;
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
}
