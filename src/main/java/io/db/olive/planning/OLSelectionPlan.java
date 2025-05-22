package io.db.olive.planning;

import io.db.olive.scanning.OLScan;

public class OLSelectionPlan implements OLPlan {
    private OLPlan underlyingPlan;

    public OLSelectionPlan(OLPlan plan) {
        this.underlyingPlan = plan;
    }

    @Override
    public OLScan open() throws Exception {
        return underlyingPlan.open();
    }
}
