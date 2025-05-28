package io.db.olive.planning.plans;

import io.db.olive.scanning.OLScan;
import io.db.olive.scanning.OLSelectionScan;
import io.db.olive.sql.OLPredicate;

public class OLSelectionPlan implements OLPlan {
    private OLPlan underlyingPlan;
    private OLPredicate predicate;

    public OLSelectionPlan(OLPlan plan, OLPredicate predicate) {
        this.underlyingPlan = plan;
        this.predicate = predicate;
    }

    @Override
    public OLScan open() throws Exception {
        OLScan scan = underlyingPlan.open();
        return new OLSelectionScan(scan, predicate);
    }
}
