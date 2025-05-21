package io.db.olive.sql.dml;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;

public class OLInsertIntoTableSQL implements OLSQLBase {

    @Override
    public OLSQLResult getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
