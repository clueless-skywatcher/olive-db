package io.db.olive.sql;

import io.db.olive.data.OLSerializable;
import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLTerm {
    private @Getter String lhs;
    private @Getter OLSerializable<?> rhs;

    public OLTerm(String lhs, OLSerializable<?> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public boolean isSatisfied(OLTuple tuple) throws Exception {
        try {
            OLSerializable<?> val = tuple.getField(lhs);
            return val.equals(rhs);
        } catch (Exception e) {
            throw new Exception("Field not a part of tuple: " + lhs);
        }
    }

    public String toString() {
        return String.format("%s = %s", lhs, rhs.toString());
    }
    
}
