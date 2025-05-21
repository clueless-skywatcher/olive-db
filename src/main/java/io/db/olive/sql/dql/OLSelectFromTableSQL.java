package io.db.olive.sql.dql;

import java.util.List;

import lombok.Getter;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.scanning.OLProjectionScan;
import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLSequentialScan;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import io.db.olive.tuples.OLTuple;

public class OLSelectFromTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private @Getter List<String> columnList;
    private @Getter OLSQLResult result;

    public OLSelectFromTableSQL(String tableName, List<String> columnList) {
        this.tableName = tableName;
        this.columnList = columnList;
        this.result = new OLSQLResult();
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLScan scan = new OLSequentialScan(tableName, database, bufferPool);
        
        if (columnList.size() > 0) {
            scan = new OLProjectionScan(scan, columnList);
        }
        
        OLSQLResult result = new OLSQLResult();
        while (scan.hasNext()) {
            OLTuple nextTuple = scan.next();
            if (nextTuple != null) {
                result.addTuple(nextTuple);
            }
        }
        this.result = result;
    }
    
}
