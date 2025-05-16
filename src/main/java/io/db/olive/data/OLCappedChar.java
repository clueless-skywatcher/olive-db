package io.db.olive.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLCappedChar implements OLSerializable<String> {
    private @Getter String value;
    private int cap;

    @Override
    public byte[] serialize() {
        return value.getBytes();
    }

    @Override
    public int getMaxSize() {
        return cap;
    }

    public String toString() {
        return value;
    }
}
