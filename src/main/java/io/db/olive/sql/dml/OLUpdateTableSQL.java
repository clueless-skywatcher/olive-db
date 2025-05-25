package io.db.olive.sql.dml;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLSerializable;
import io.db.olive.scanning.OLSequentialScan;
import io.db.olive.scanning.OLWriteableScan;
import io.db.olive.sql.OLPredicate;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import lombok.Getter;

public class OLUpdateTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private @Getter OLPredicate predicate;
    private @Getter String setFieldName;
    private @Getter OLSerializable<?> setValue;
    private @Getter OLSQLResult result;

    public OLUpdateTableSQL(String tableName, OLPredicate predicate, String setFieldName, OLSerializable<?> setValue) {
        this.tableName = tableName;
        this.predicate = predicate;
        this.setFieldName = setFieldName;
        this.setValue = setValue;
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLWriteableScan scan = new OLSequentialScan(tableName, database, bufferPool);
        while (scan.hasNext()) {
            scan.update(predicate, setFieldName, setValue);
            scan.next();
        }
        bufferPool.flushAll();
    }
    
}
