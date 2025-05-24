package io.db.olive.data.info;

public class OLIntegerInfo implements OLDataInfo {
    @Override
    public int getMaxSize() {
        return Integer.BYTES;
    }

    @Override
    public String getDataType() {
        return "Integer";
    }

    @Override
    public String getSQLTypeName() {
        return "int";
    }
}
