package io.db.olive.planning.plans;

import io.db.olive.scanning.OLScan;

public interface OLPlan {
    public OLScan open() throws Exception;

}
