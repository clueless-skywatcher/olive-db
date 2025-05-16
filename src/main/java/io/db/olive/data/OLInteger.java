package io.db.olive.data;

import java.nio.ByteBuffer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLInteger implements OLSerializable<Integer> {
    private @Getter Integer value;

    @Override
    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.allocate(Integer.BYTES);
        buf.putInt(value);
        return buf.array();
    }

    @Override
    public int getMaxSize() {
        return Integer.BYTES;
    } 

    public String toString() {
        return Integer.toString(value);
    }
}
