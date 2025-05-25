package io.db.olive.sql.dml;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLSerializable;
import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLSequentialScan;
import io.db.olive.scanning.OLWriteableScan;
import io.db.olive.sql.OLPredicate;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import lombok.Getter;

public class OLDeleteFromTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private @Getter OLPredicate predicate;
    private @Getter OLSQLResult result;

    public OLDeleteFromTableSQL(String tableName, OLPredicate predicate) {
        this.tableName = tableName;
        this.predicate = predicate;
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLWriteableScan scan = new OLSequentialScan(tableName, database, bufferPool);
        while (scan.hasNext()) {
            scan.delete(predicate);
            scan.next();
        }
        bufferPool.flushAll();
    }
}
