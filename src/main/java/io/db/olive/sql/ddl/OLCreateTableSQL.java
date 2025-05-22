package io.db.olive.sql.ddl;

import java.util.Map;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;
import io.db.olive.tuples.OLTupleSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLCreateTableSQL implements OLSQLBase {
    private @Getter String tableName;
    private Map<String, OLDataInfo> columnMap;
    private @Getter OLSQLResult result;

    public OLCreateTableSQL(String tableName, Map<String, OLDataInfo> columnMap) {
        this.tableName = tableName;
        this.columnMap = columnMap;
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLTupleSchema schema = new OLTupleSchema();
        for (Map.Entry<String, OLDataInfo> entry: columnMap.entrySet()) {
            schema.addField(entry.getKey(), entry.getValue());
        }
        database.createTableFile(tableName, schema);
        // TODO: Add an entry to ol_tables meta table
        // TODO: Add entries for each column in ol_attributes meta table
    }
    
}
