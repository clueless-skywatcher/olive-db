package io.db.olive.sql;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;

public interface OLSQLBase {
    public OLSQLResult getResult();
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception;
}
