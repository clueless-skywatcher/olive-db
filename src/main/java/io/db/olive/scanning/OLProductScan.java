package io.db.olive.scanning;

import java.util.Map;

import io.db.olive.data.OLSerializable;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

public class OLProductScan implements OLScan {
    private OLScan p1;
    private OLScan p2;

    public OLProductScan(OLScan p1, OLScan p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean hasNext() throws Exception {
        return p1.hasNext() || p2.hasNext();
    }

    @Override
    public void next() throws Exception {
        if (p2.hasNext()) {
            p2.next();
        } else {
            p2.rewind();
            if (p1.hasNext()) {
                p1.next();
            }
        }
    }

    @Override
    public OLTupleSchema getSchema() {
        OLTupleSchema newSchema = new OLTupleSchema();
        for (String field: p1.getSchema().getFields()) {
            if (!newSchema.contains(field)) {
                newSchema.addField(field, p1.getSchema().getInfo(field));
            }
        }
        
        for (String field: p2.getSchema().getFields()) {
            if (!newSchema.contains(field)) {
                newSchema.addField(field, p2.getSchema().getInfo(field));
            }
        }

        return newSchema;
    }

    @Override
    public OLTuple getCurrentRow() throws Exception {
        OLTuple finalTuple = new OLTuple(getSchema());

        OLTuple tuple1 = p1.getCurrentRow();
        OLTuple tuple2 = p2.getCurrentRow();
        
        if (tuple1 == null || tuple2 == null) {
            return null;
        }

        for (Map.Entry<String, OLSerializable<?>> val: tuple1.getFields().entrySet()) {
            finalTuple.addField(val.getKey(), val.getValue());
        }

        for (Map.Entry<String, OLSerializable<?>> val: tuple2.getFields().entrySet()) {
            finalTuple.addField(val.getKey(), val.getValue());
        }
        return finalTuple;
    }

    @Override
    public String toString(String indent) {
        return "";
    }

    @Override
    public void rewind() throws Exception {
        p1.rewind();
        p2.rewind();
    }
    
}
