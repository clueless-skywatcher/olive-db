package io.db.olive.planning.plans;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLSequentialScan;

public class OLSequentialPlan implements OLPlan {
    private String tableName;
    private OLDatabase database;
    private OLBufferPool bufferPool;

    public OLSequentialPlan(String tableName, OLDatabase database, OLBufferPool pool) {
        this.tableName = tableName;
        this.database = database;
        this.bufferPool = pool;
    }

    @Override
    public OLScan open() throws Exception {
        return new OLSequentialScan(tableName, database, bufferPool);
    }
    

}
