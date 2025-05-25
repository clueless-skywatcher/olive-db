package io.db.olive.scanning;

import java.util.List;

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
            this.schema.addField(field, underlyingSchema.getInfo(field));
        }
    }

    @Override
    public boolean hasNext() {
        return underlyingScan.hasNext();
    }

    @Override
    public OLTuple next() throws Exception {
        OLTuple nextTuple = underlyingScan.next();
        OLTupleSchema schema = nextTuple.getSchema();
        OLTuple projectedTuple = new OLTuple(schema);
        
        for (String field: fields) {
            projectedTuple.addField(field, nextTuple.getField(field));
        }
        return projectedTuple;
    }

    public String toString() {
        return String.format("""
        ProjectionScan
        ---> %s
        ---> With fields: %s""", 
        underlyingScan.toString(),
        fields.toString()
        );
    }
    
}
