package io.db.olive.sql;

import java.util.ArrayList;
import java.util.List;

import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLSQLResult {
    private @Getter List<OLTuple> tuples;

    public OLSQLResult() {
        this.tuples = new ArrayList<>();
    }

    public void addTuple(OLTuple tuple) {
        this.tuples.add(tuple);
    }
}
