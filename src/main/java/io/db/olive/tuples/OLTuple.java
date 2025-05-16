package io.db.olive.tuples;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

import io.db.olive.data.OLSerializable;

import lombok.Getter;

public class OLTuple {
    private @Getter OLTupleSchema schema;
    private Map<String, OLSerializable<?>> fields;

    public OLTuple(OLTupleSchema schema) {
        this.schema = schema;
        this.fields = new LinkedHashMap<>();
    }

    public void addField(String name, OLSerializable<?> field) {
        if (schema.contains(name)) {
            if (field.getClass() != schema.getInfo(name).getDataType()) {
                throw new IllegalArgumentException("Field " + name + " has wrong type");
            }
            fields.put(name, field);
        } else {
            throw new IllegalArgumentException("Field " + name + " not in schema");
        }
    }


    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.allocate(schema.getSize());
        buf.put((byte) 1);
        for (Map.Entry<String, OLSerializable<?>> entry: fields.entrySet()) {
            int offset = schema.getOffset(entry.getKey());
            buf.position(offset);
            buf.put(entry.getValue().serialize());
        }

        return buf.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, OLSerializable<?>> entry: fields.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue().toString()).append(", ");
        }
        return sb.toString();
    }
}
