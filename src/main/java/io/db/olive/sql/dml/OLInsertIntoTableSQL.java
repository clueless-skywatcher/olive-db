package io.db.olive.sql.dml;

import java.util.Map;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLSerializable;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLInsertIntoTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private Map<String, OLSerializable<?>> valueMap;
    private @Getter OLSQLResult result;


    public OLInsertIntoTableSQL(String tableName, Map<String, OLSerializable<?>> valueMap) {
        this.tableName = tableName;
        this.valueMap = valueMap;
    }

    @Override
    public OLSQLResult getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLTupleSchema schema = database.getSchema(tableName);
        OLTuple tuple = new OLTuple(schema);
        for (Map.Entry<String, OLSerializable<?>> value: valueMap.entrySet()) {
            tuple.addField(value.getKey(), value.getValue());
        }

        database.insertTuple(tableName, tuple, bufferPool);
    }
    
}
