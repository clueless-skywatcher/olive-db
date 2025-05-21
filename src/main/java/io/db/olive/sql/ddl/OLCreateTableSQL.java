package io.db.olive.sql.ddl;

import java.util.Map;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLCreateTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private Map<String, OLDataInfo> columnMap;

    @Override
    public OLSQLResult getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
