package io.db.olive.tuples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.db.olive.data.info.OLDataInfo;
import lombok.Getter;

public class OLTupleSchema {
    private Map<String, OLDataInfo> schema = new LinkedHashMap<>();
    private Map<String, Integer> offsets = new LinkedHashMap<>();
    private @Getter int size = 0;

    public void addField(String name, OLDataInfo info) {
        schema.put(name, info);
        offsets.put(name, size);
        size += info.getMaxSize();
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
}
