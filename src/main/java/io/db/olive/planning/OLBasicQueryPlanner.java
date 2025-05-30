package io.db.olive.planning;

import java.util.ArrayList;
import java.util.List;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.planning.plans.OLPlan;
import io.db.olive.planning.plans.OLProductPlan;
import io.db.olive.planning.plans.OLProjectionPlan;
import io.db.olive.planning.plans.OLSelectionPlan;
import io.db.olive.planning.plans.OLSequentialPlan;
import io.db.olive.sql.dql.OLSelectFromTableSQL;

public class OLBasicQueryPlanner implements OLQueryPlanner {

    @Override
    public OLPlan generatePlan(OLSelectFromTableSQL query, OLDatabase database, OLBufferPool bufferPool) throws Exception {
        List<OLPlan> plans = new ArrayList<>();
        for (String tableName: query.getTableNames()) {
            plans.add(new OLSequentialPlan(tableName, database, bufferPool));
        }

        OLPlan plan = plans.remove(0);
        for (OLPlan nextPlan: plans) {
            plan = new OLProductPlan(plan, nextPlan);
        }

        if (query.getPredicate() != null) {
            plan = new OLSelectionPlan(plan, query.getPredicate());
        }

        if (query.getColumnList().size() > 0) {
            plan = new OLProjectionPlan(plan, query.getColumnList());
        }

        return plan;
    }
    
}
