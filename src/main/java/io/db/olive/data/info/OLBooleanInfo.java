package io.db.olive.data.info;

import io.db.olive.data.OLBoolean;

public class OLBooleanInfo implements OLDataInfo {
    @Override
    public int getMaxSize() {
        return 1;
    }

    @Override
    public Class<?> getDataType() {
        return OLBoolean.class;
    }
}
