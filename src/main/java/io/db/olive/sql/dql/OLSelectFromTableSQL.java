package io.db.olive.sql.dql;

import java.util.List;

import lombok.Getter;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.planning.OLBasicQueryPlanner;
import io.db.olive.planning.OLQueryPlanner;
import io.db.olive.planning.plans.OLPlan;
import io.db.olive.scanning.OLScan;
import io.db.olive.sql.OLPredicate;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLSQLResult;

public class OLSelectFromTableSQL implements OLSQLBase {
    private @Getter List<String> tableNames;
    private @Getter List<String> columnList;
    private @Getter OLPredicate predicate;
    private @Getter OLSQLResult result;
    private String query;

    public OLSelectFromTableSQL(
        List<String> tableNames, 
        List<String> columnList, 
        OLPredicate predicate,
        String query
    ) {
        this.tableNames = tableNames;
        this.columnList = columnList;
        this.query = query;
        this.predicate = predicate;
    }

    @Override
    public void execute(OLDatabase database, OLBufferPool bufferPool) throws Exception {
        OLQueryPlanner planner = new OLBasicQueryPlanner();
        OLPlan plan = planner.generatePlan(this, database, bufferPool);

        OLScan scan = plan.open();
        
        OLSQLResult result = new OLSQLResult(scan.getSchema());
        while (scan.hasNext()) {
            if (scan.getCurrentRow() != null) {
                result.addTuple(scan.getCurrentRow());
            }
            scan.next();
        }
        this.result = result;
        System.out.println(scan.toString());
    }

    public String toString() {
        return query;
    }
    
}
