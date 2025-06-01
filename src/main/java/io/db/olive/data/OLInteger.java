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

    @Override
    public String getDataType() {
        return "Integer";
    }

    public boolean equals(Object other) {
        if (other instanceof OLSerializable<?>) {
            OLSerializable<?> otherObj = (OLSerializable<?>) other;
            return this.value.equals(otherObj.getValue());
        }

        return false;
    }

    @Override
    public int compareTo(OLSerializable<?> o) throws Exception {
        if (o == null) {
            return 1;
        }

        if (o instanceof OLInteger) {
            OLInteger intVal = (OLInteger) o;
            return Integer.compare(this.value, intVal.getValue());
        }

        throw new Exception("Cannot compare OLInteger with " + o);
    }
}
