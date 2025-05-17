package io.db.olive.storage;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.db.olive.OLOptions;
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
        String path = Paths.get(".olive", "db", dbName).toString();
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

    public List<OLTuple> selectAllTuples(String tableName, OLTupleSchema schema) throws Exception {
        OLDataFile file = startTableFile(tableName, schema);
        long pageCount = file.getPageCount();
        List<OLTuple> tuples = new ArrayList<>();
        int pageNo = 0;
        while (pageNo < pageCount) {
            OLPage page = file.readPage(pageNo);
            int count = page.getHeader().getSlotCounts();
            int slot = 0;
            while (slot < count) {
                byte[] tupleBytes = page.readTupleBytes(slot);
                OLTuple tuple = OLTuple.deserialize(tupleBytes, schema);
                if (tuple != null) {
                    tuples.add(tuple);
                }
                slot++;
            }
            pageNo++;
        }
        return tuples;
    }

    public void insertTuple(String tableName, OLTuple tuple) throws Exception {
        OLDataFile tableFile = startTableFile(tableName, tuple.getSchema());
        tableFile.insertTuple(tuple);
    }
}
