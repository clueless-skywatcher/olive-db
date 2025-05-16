package io.db.olive.data.info;

import io.db.olive.data.OLCappedChar;

public class OLCappedCharInfo implements OLDataInfo {
    private int cap;

    public OLCappedCharInfo(int cap) {
        this.cap = cap;
    }

    @Override
    public int getMaxSize() {
        return cap;
    }

    @Override
    public Class<?> getDataType() {
        return OLCappedChar.class; // Assuming the data type is String for capped characters
    }
}
