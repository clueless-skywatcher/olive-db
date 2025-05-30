package io.db.olive.scanning;

import java.util.List;

import io.db.olive.data.OLCappedChar;
import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLProjectionScan implements OLScan {
    private OLScan underlyingScan;
    private List<String> fields;
    private @Getter OLTupleSchema schema;

    public OLProjectionScan(OLScan underlyingScan, List<String> fields) {
        this.underlyingScan = underlyingScan;
        this.fields = fields;

        this.schema = new OLTupleSchema();
        OLTupleSchema underlyingSchema = underlyingScan.getSchema();
        for (String field: fields) {
            if (field.equals("ctid")) {
                this.schema.addField(field, new OLCappedCharInfo(50));
            } else {
                this.schema.addField(field, underlyingSchema.getInfo(field));
            }
        }
    }

    @Override
    public boolean hasNext() throws Exception {
        return underlyingScan.hasNext();
    }

    @Override
    public void next() throws Exception {
        underlyingScan.next();
    }

    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        return String.format("""
        %sProjectionScan
        %s---> %s
        %s---> On fields: %s""", 
        indent,
        indent, underlyingScan.toString(indent + " "),
        indent, fields.toString());
    }

    @Override
    public OLTuple getCurrentRow() throws Exception {
        OLTuple tuple = underlyingScan.getCurrentRow();
        if (tuple == null) {
            return null;
        }

        OLTupleSchema schema = tuple.getSchema();
        if (fields.contains("ctid")) {
            schema.addField("ctid", new OLCappedCharInfo(50));
        }
        OLTuple projectedTuple = new OLTuple(schema);
        
        for (String field: fields) {
            if (field.equals("ctid")) {
                projectedTuple.addField(field, new OLCappedChar(tuple.getId().toString(), 50));
            } else {
                projectedTuple.addField(field, tuple.getField(field));
            }
        }
        return projectedTuple;
    }

    @Override
    public void rewind() throws Exception {
        underlyingScan.rewind();
    }
    
}
