package io.db.olive.data.info;

import io.db.olive.data.OLSerializable;

public interface OLDataInfo {
    public int getMaxSize();
    public Class<?> getDataType();
}
