package io.db.olive.data.info;

public class OLBooleanInfo implements OLDataInfo {
    @Override
    public int getMaxSize() {
        return 1;
    }

    @Override
    public String getDataType() {
        return "Boolean";
    }
}
