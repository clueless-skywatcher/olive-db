package io.db.olive.planning.plans;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLTempTable;
import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLMaterializationPlan implements OLPlan {
    private OLPlan underlyingPlan;
    private OLDatabase database;
    private OLBufferPool bufferPool;
    private @Getter String tableName;

    public OLMaterializationPlan(String tableName, OLPlan underlyingPlan, OLDatabase database, OLBufferPool bufferPool) {
        this.underlyingPlan = underlyingPlan;
        this.database = database;
        this.bufferPool = bufferPool;
        this.tableName = tableName;
    }

    @Override
    public OLScan open() throws Exception {
        OLScan underlyingScan = underlyingPlan.open();
        OLTempTable tempTable = new OLTempTable("@@temp_" + tableName, database, bufferPool);
        while (underlyingScan.hasNext()) {
            OLTuple row = underlyingScan.getCurrentRow();
            tempTable.insertTuple(row);
        }

        return tempTable.open();
    }
    
}
