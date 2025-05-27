package io.db.olive.tuples;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class OLTupleIdentifier {
    private @Getter long pageNo;
    private @Getter int slotNo;

    public String toString() {
        return String.format("(%s, %s)", pageNo, slotNo);
    }
}
