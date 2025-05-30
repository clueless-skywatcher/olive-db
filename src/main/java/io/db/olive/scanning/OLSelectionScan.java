package io.db.olive.scanning;

import io.db.olive.sql.OLPredicate;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLSelectionScan implements OLScan {
    private OLScan underlyingScan;
    private @Getter OLTupleSchema schema;
    private @Getter OLPredicate predicate;

    public OLSelectionScan(OLScan underlyingScan, OLPredicate predicate) {
        this.underlyingScan = underlyingScan;
        this.schema = underlyingScan.getSchema();
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() throws Exception {
        return underlyingScan.hasNext();
    }

    @Override
    public void next() throws Exception {
        while (underlyingScan.hasNext()) {
            underlyingScan.next();
            if (predicate.isSatisfied(underlyingScan.getCurrentRow())) {
                break;
            }
        }
    } 

    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        return String.format("""
        %sSelectionScan
        %s---> %s
        %s---> %s""", 
        indent,
        indent, underlyingScan.toString(indent + " "),
        indent, predicate.toString());
    }

    @Override
    public OLTuple getCurrentRow() throws Exception {
        OLTuple currentRow = underlyingScan.getCurrentRow();
        if (currentRow == null || !predicate.isSatisfied(currentRow)) {
            return null;
        }

        return currentRow;
    }

    @Override
    public void rewind() throws Exception {
        underlyingScan.rewind();
    }
}
