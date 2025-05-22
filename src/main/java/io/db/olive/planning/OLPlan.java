package io.db.olive.planning;

import io.db.olive.scanning.OLScan;

public interface OLPlan {
    public OLScan open() throws Exception;

}
