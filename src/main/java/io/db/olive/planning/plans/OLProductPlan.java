package io.db.olive.planning.plans;

import io.db.olive.scanning.OLProductScan;
import io.db.olive.scanning.OLScan;

public class OLProductPlan implements OLPlan {
    private OLPlan p1;
    private OLPlan p2;

    public OLProductPlan(OLPlan p1, OLPlan p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public OLScan open() throws Exception {
        return new OLProductScan(p1.open(), p2.open());
    }
    
}
