package io.db.olive.tuples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.db.olive.data.info.OLBooleanInfo;
import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.data.info.OLIntegerInfo;
import lombok.Getter;

public class OLTupleSchema {
    private Map<String, OLDataInfo> schema = new LinkedHashMap<>();
    private Map<String, Integer> offsets = new LinkedHashMap<>();
    private @Getter int size = 0;

    public void addField(String name, OLDataInfo info) {
        schema.put(name, info);
        if (!name.equals("ctid")) {
            offsets.put(name, size);
            size += info.getMaxSize();
        }
    }

    public boolean contains(String name) {
        return schema.containsKey(name);
    }

    public OLDataInfo getInfo(String name) {
        return schema.get(name);
    }

    public int getOffset(String name) {
        return offsets.get(name);
    }

    public int getMaxSize(String name) {
        return schema.get(name).getMaxSize();
    }

    public List<String> getFields() {
        return new ArrayList<>(schema.keySet());
    }

    public String getCreateTableAttributeString() {
        StringJoiner joiner = new StringJoiner(", ");

        for (Map.Entry<String, OLDataInfo> entry: schema.entrySet()) {
            String val = entry.getValue().getSQLTypeName();
            joiner.add(String.format("%s %s", entry.getKey(), val));
        }

        return joiner.toString();
    }

    public String getInsertionAttributeString() {
        StringJoiner joiner = new StringJoiner(", ");

        for (String fieldName: schema.keySet()) {
            joiner.add(fieldName);
        }

        return joiner.toString();
    }

    public static OLDataInfo inferTypeFromDataTypeString(String dataType) throws Exception {
        dataType = dataType.toLowerCase();
        if (dataType.equals("int")) {
            return new OLIntegerInfo();
        } else if (dataType.equals("boolean")) {
            return new OLBooleanInfo();
        } else if (dataType.startsWith("varchar")) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(dataType);

            if (matcher.find()) {
                int cap = Integer.parseInt(matcher.group(0));
                return new OLCappedCharInfo(cap);
            } else {
                throw new Exception("Invalid datatype name: " + dataType);
            }
        }
        else {
            return null;
        }
    } 
}
