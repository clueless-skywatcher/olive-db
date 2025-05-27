package io.db.olive.sql;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;
import lombok.Getter;

public class OLSQLResult {
    private @Getter List<OLTuple> tuples;
    private @Getter OLTupleSchema schema;

    public OLSQLResult(OLTupleSchema schema) {
        this.tuples = new ArrayList<>();
        this.schema = schema;
    }

    public void addTuple(OLTuple tuple) {
        this.tuples.add(tuple);
    }

    public String toString() {
        List<String> fields = schema.getFields();

        Map<String, Integer> columnWidths = new LinkedHashMap<>();

        for (String field: fields) {
            columnWidths.put(field, field.length());
        }

        for (OLTuple tuple: tuples) {
            for (String field: fields) {
                String val = tuple.getField(field).toString();
                if (val.length() > columnWidths.get(field)) {
                    columnWidths.put(field, val.length());
                }
            }
        }
        StringBuilder fullResultBuilder = new StringBuilder();

        StringBuilder headerBuilder = new StringBuilder("|");
        for (String field: fields) {
            Integer columnWidth = columnWidths.get(field);
            headerBuilder.append(" %-").append(columnWidth).append("s |");
        }
        fullResultBuilder.append(String.format(headerBuilder.toString(), fields.toArray()));
        fullResultBuilder.append("\n");

        fullResultBuilder.append("+");
        for (String field: fields) {
            fullResultBuilder.append("-".repeat(columnWidths.get(field) + 2) + "+");
        }
        fullResultBuilder.append("\n");

        for (OLTuple tuple: tuples) {
            List<String> tupleValues = new ArrayList<>();
            for (String field: fields) {
                String val = tuple.getField(field).toString();
                tupleValues.add(val);
            }
            fullResultBuilder.append(String.format(headerBuilder.toString(), tupleValues.toArray()));
            fullResultBuilder.append("\n");
        }

        fullResultBuilder.append("+");
        for (String field: fields) {
            fullResultBuilder.append("-".repeat(columnWidths.get(field) + 2) + "+");
        }
        fullResultBuilder.append("\n");

        return fullResultBuilder.toString();
    }
}
