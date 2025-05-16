package io.db.olive.data.info;

import io.db.olive.data.OLInteger;

public class OLIntegerInfo implements OLDataInfo {
    @Override
    public int getMaxSize() {
        return Integer.BYTES;
    }

    @Override
    public Class<?> getDataType() {
        return OLInteger.class;
    }
}
