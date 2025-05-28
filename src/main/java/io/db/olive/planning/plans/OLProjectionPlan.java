package io.db.olive.planning.plans;

import java.util.List;

import io.db.olive.scanning.OLProjectionScan;
import io.db.olive.scanning.OLScan;

public class OLProjectionPlan implements OLPlan {
    private OLPlan underlyingPlan;
    private List<String> fields;

    public OLProjectionPlan(OLPlan underlyingPlan, List<String> fields) {
        this.underlyingPlan = underlyingPlan;
        this.fields = fields;
    }
    @
    Override
    public OLScan open() throws Exception {
        return new OLProjectionScan(underlyingPlan.open(), fields);
    }
    
}
