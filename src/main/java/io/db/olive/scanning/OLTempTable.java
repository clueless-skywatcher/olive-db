package io.db.olive.scanning;

import java.util.List;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLTempTable {
    private @Getter String tableName;
    private @Getter List<OLTuple> tuples;
    private @Getter OLBufferPool bufferPool;
    private @Getter OLDatabase database;

    public OLTempTable(String tableName, OLDatabase database, OLBufferPool bufferPool) {
        this.tableName = tableName;
        this.database = database;
        this.bufferPool = bufferPool;
    }

    public OLScan open(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        return new OLSequentialScan(tableName, database, bufferPool);
    }

    public void insertTuple(OLTuple tuple) throws Exception {
        database.insertTuple(tableName, tuple);
    }
}
