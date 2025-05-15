package io.db.olive;

import io.db.olive.storage.OLStorageManager;
import lombok.Getter;

public class OLDatabase {
    private OLStorageManager storageManager;
    private OLOptions options;
    private @Getter String dbName;

    public OLDatabase(String dbName, OLOptions options) throws Exception {
        this.options = options;
        this.storageManager = new OLStorageManager(dbName, this.options);
    }

    public void createTable(String tableName) throws Exception {
        this.storageManager.startTableFile(tableName);
    }
}
