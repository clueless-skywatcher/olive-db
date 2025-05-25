package io.db.olive.sql.dml;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLSerializable;
import io.db.olive.sql.OLPredicate;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import lombok.Getter;

public class OLDeleteFromTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private @Getter OLPredicate predicate;
    private @Getter OLSQLResult result;

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
