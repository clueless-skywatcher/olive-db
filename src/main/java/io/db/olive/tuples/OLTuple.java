package io.db.olive.tuples;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

import io.db.olive.data.OLBoolean;
import io.db.olive.data.OLCappedChar;
import io.db.olive.data.OLInteger;
import io.db.olive.data.OLSerializable;
import io.db.olive.data.info.OLDataInfo;

import lombok.Getter;

public class OLTuple {
    private @Getter OLTupleSchema schema;
    private Map<String, OLSerializable<?>> fields;
    private @Getter int id;

    public OLTuple(OLTupleSchema schema) {
        this.schema = schema;
        this.fields = new LinkedHashMap<>();
    }

    public OLTuple() {
        this.schema = null;
        this.fields = new LinkedHashMap<>();
    }

    public OLSerializable<?> getField(String fieldName) {
        return this.fields.get(fieldName);
    }

    public void addField(String name, OLSerializable<?> field) {
        if (schema.contains(name)) {
            if (field.getDataType() != schema.getInfo(name).getDataType()) {
                throw new IllegalArgumentException("Field " + name + " has wrong type");
            }
            fields.put(name, field);
        } else {
            throw new IllegalArgumentException("Field " + name + " not in schema");
        }
    }


    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.allocate(schema.getSize());
        for (Map.Entry<String, OLSerializable<?>> entry: fields.entrySet()) {
            int offset = schema.getOffset(entry.getKey());
            buf.position(offset);
            buf.put(entry.getValue().serialize());
        }

        return buf.array();
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<String, OLSerializable<?>> entry: fields.entrySet()) {
            joiner.add(entry.getKey() + ": " + entry.getValue().toString());
        }
        return "{" + joiner.toString() + "}";
    }

    public static OLTuple deserialize(byte[] tupleBytes, OLTupleSchema schema) {
        ByteBuffer buffer = ByteBuffer.wrap(tupleBytes);
        OLTuple tuple = new OLTuple(schema);
        
        for (String field: schema.getFields()) {
            int offset = schema.getOffset(field);
            OLDataInfo fieldType = schema.getInfo(field);
            buffer.position(offset);

            switch (fieldType.getDataType()) {
                case "Integer":
                    OLInteger val = new OLInteger(buffer.getInt());
                    tuple.addField(field, val);
                    break;
                case "CappedChar":
                    int length = buffer.getInt();
                    byte[] charBytes = new byte[length];
                    buffer.get(charBytes);
                    OLCappedChar cappedChar = new OLCappedChar(
                        new String(charBytes), fieldType.getMaxSize());
                    tuple.addField(field, cappedChar);
                    break;
                case "Boolean":
                    byte bool = buffer.get();
                    OLBoolean boolObject = new OLBoolean(bool == (byte) 1);
                    tuple.addField(field, boolObject);
                    break;
                default:
                    break;
            }
        }
        return tuple;
    }
}
