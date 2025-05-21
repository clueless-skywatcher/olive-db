package io.db.olive.data;

import java.nio.ByteBuffer;

import lombok.Getter;

public class OLCappedChar implements OLSerializable<String> {
    private @Getter String value;
    private int cap;

    public OLCappedChar(String value, int cap) {
        if (value.length() > cap) {
            this.value = value.substring(0, cap);
        } else {
            this.value = value;
        }
        this.cap = cap;
    }

    @Override
    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.allocate(Integer.BYTES + value.length());
        buf.putInt(value.length());
        buf.put(value.getBytes());
        return buf.array();
    }

    @Override
    public int getMaxSize() {
        return Integer.BYTES + cap;
    }

    public String toString() {
        return value;
    }

    @Override
    public String getDataType() {
        return "CappedChar";
    }
}
