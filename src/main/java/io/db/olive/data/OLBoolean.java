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
    
}
