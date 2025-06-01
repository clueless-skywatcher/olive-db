package io.db.olive.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class OLBoolean implements OLSerializable<Boolean> {
    private @Getter @Setter Boolean value;
    
    @Override
    public byte[] serialize() {
        byte[] val = new byte[1];
        val[0] = (byte) (value ? 1 : 0);
        return val;
    }

    @Override
    public int getMaxSize() {
        return 1;
    }

    public String toString() {
        return value.toString();
    }

    @Override
    public String getDataType() {
        return "Boolean";
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
        
        if (o instanceof OLBoolean) {
            OLBoolean other = (OLBoolean) o;
            return this.value.compareTo(other.getValue());
        }
        throw new Exception("Cannot compare OLBoolean with " + o);
    }
}
