package io.db.olive.data.info;

public class OLCappedCharInfo implements OLDataInfo {
    private int cap;

    public OLCappedCharInfo(int cap) {
        this.cap = cap;
    }

    @Override
    public int getMaxSize() {
        return Integer.BYTES + cap;
    }

    @Override
    public String getDataType() {
        return "CappedChar";
    }

    @Override
    public String getSQLTypeName() {
        return String.format("varchar(%d)", cap);
    }

    
}
