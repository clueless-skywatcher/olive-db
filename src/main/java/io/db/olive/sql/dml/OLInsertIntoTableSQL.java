package io.db.olive.sql.dml;

import java.util.List;
import java.util.Map;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLBoolean;
import io.db.olive.data.OLCappedChar;
import io.db.olive.data.OLInteger;
import io.db.olive.data.OLSerializable;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

import lombok.Getter;

public class OLInsertIntoTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private Map<String, String> valueMap;
    private List<String> valueList;
    private OLSQLResult result;
    private String query;

    public OLInsertIntoTableSQL(String tableName, Map<String, String> valueMap, String query) {
        this.tableName = tableName;
        this.valueMap = valueMap;
        this.query = query;
    }

    public OLInsertIntoTableSQL(String tableName, List<String> valueList, String query) {
        this.tableName = tableName;
        this.valueList = valueList;
        this.query = query;
    }

    @Override
    public OLSQLResult getResult() {
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLTupleSchema schema = database.getSchema(tableName);
        OLTuple tuple = new OLTuple(schema);
            
        if (valueMap != null) {
            for (Map.Entry<String, String> value: valueMap.entrySet()) {
                String columnName = value.getKey();
                String columnValue = value.getValue();

                tuple.addField(columnName, inferValue(columnValue, schema, columnName));
            }

        } else {
            List<String> allFields = schema.getFields();
            for (int i = 0; i < valueList.size(); i++) {
                String value = valueList.get(i);
                String field = allFields.get(i);
                tuple.addField(field, inferValue(value, schema, field));
            }
        }

        database.insertTuple(tableName, tuple);
    }

    private OLSerializable<?> inferValue(String columnValue, OLTupleSchema schema, String columnName) throws Exception {
        OLSerializable<?> val;

        switch (schema.getInfo(columnName).getDataType()) {
            case "Integer":
                val = new OLInteger(Integer.parseInt(columnValue));
                return val;
            case "CappedChar":
                val = new OLCappedChar(
                    columnValue.substring(1, columnValue.length() - 1), 
                    schema.getMaxSize(columnName)
                );
                return val;
            case "Boolean":
                val = new OLBoolean(Boolean.parseBoolean(columnValue.toLowerCase()));
                return val;
            default:
                throw new Exception("Invalid data type");
        }
    }  
    
    public String toString() {
        return query;
    }  
}
