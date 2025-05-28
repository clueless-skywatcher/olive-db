package io.db.olive.planning;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.planning.plans.OLPlan;
import io.db.olive.sql.dql.OLSelectFromTableSQL;

public interface OLQueryPlanner {
    public OLPlan generatePlan(OLSelectFromTableSQL query, OLDatabase database, OLBufferPool bufferPool) throws Exception;
}
