package io.db.olive.storage;

import java.io.File;
import java.nio.file.Paths;

import io.db.olive.OLOptions;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLStorageManager {
    private @Getter String dbName;
    private File dataDir;
    private @Getter int pageSize;

    public OLStorageManager(String dbName, OLOptions options) throws Exception {
        this.dbName = dbName;
        this.pageSize = options.getPageSize();
        String path = Paths.get(".olive", "data", dbName).toString();
        dataDir = new File(path);
        if (!dataDir.exists()) {
            boolean success = dataDir.mkdirs();
            if (!success) {
                throw new Exception("Failed to initialize directory");
            }
        }       
    }

    public OLDataFile startTableFile(String tableName, OLTupleSchema schema) throws Exception {
        String tableFilePath = Paths.get(dataDir.getPath(), tableName + ".oltb").toString();
        File tableFile = new File(tableFilePath);
        return new OLDataFile(tableFile, pageSize, schema.getSize());
    }

    public void dropDatabase() throws Exception {
        deleteDir(dataDir);
    }

    private void deleteDir(File dir) throws Exception {
        File[] contents = dir.listFiles();
        if (contents != null) {
            for (File file: contents) {
                deleteDir(file);
            }
        }
        dir.delete();
    }

    public void insertTuple(String tableName, OLTuple tuple, OLBufferPool pool) throws Exception {
        OLDataFile tableFile = startTableFile(tableName, tuple.getSchema());
        tableFile.insertTuple(tuple, pool);
    }
}
