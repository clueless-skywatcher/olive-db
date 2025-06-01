package io.db.olive.scanning;

import java.util.List;

import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLScanComparator {
    private @Getter List<String> fields;

    public OLScanComparator(List<String> fields) {
        this.fields = fields;
    }

    public int compare(OLScan s1, OLScan s2, boolean descending) throws Exception {
        OLTuple currentTuple1 = s1.getCurrentRow();            
        OLTuple currentTuple2 = s2.getCurrentRow();

        return compare(currentTuple1, currentTuple2, descending);
    }

    public int compare(OLTuple t1, OLTuple t2, boolean descending) {
        if (t1 == null && t2 == null) {
            return 0;
        }
        else if (t1 == null) {
            return descending? -1 : 1;
        }
        else if (t2 == null) {
            return descending? 1 : -1;
        }

        for (String field: fields) {
            try {
                int result = t1.getField(field).compareTo(t2.getField(field));
                if (result != 0) {
                    return descending ? -result : result;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

}
