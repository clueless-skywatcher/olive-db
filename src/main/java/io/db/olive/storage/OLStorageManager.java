package io.db.olive.storage;

import java.io.File;
import java.nio.file.Paths;

import io.db.olive.OLOptions;
import lombok.Getter;

public class OLStorageManager {
    private @Getter String dbName;
    private File dataDir;
    private @Getter int pageSize;

    public OLStorageManager(String dbName, OLOptions options) throws Exception {
        this.dbName = dbName;
        this.pageSize = options.getPageSize();
        String path = Paths.get(".olive", "db", dbName).toString();
        dataDir = new File(path);
        if (!dataDir.exists()) {
            boolean success = dataDir.mkdirs();
            if (!success) {
                throw new Exception("Failed to initialize directory");
            }
        }       
    }

    public OLDataFile startTableFile(String tableName) throws Exception {
        String tableFilePath = Paths.get(dataDir.getPath(), tableName + ".oltb").toString();
        File tableFile = new File(tableFilePath);
        if (!tableFile.exists()) {
            tableFile.createNewFile();
        }
        return new OLDataFile(tableFile, pageSize);
    }
}
