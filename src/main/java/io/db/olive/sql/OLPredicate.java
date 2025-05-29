package io.db.olive.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLPredicate {
    private @Getter List<OLTerm> terms = new ArrayList<>();

    public OLPredicate() {

    }

    public OLPredicate(OLTerm t) {
        terms.add(t);
    }

    public void addTerm(OLTerm t) {
        terms.add(t);
    }

    public void addAll(OLPredicate p) {
        terms.addAll(p.getTerms());
    }

    public boolean isSatisfied(OLTuple tuple) throws Exception {
        if (tuple == null) {
            return false;
        }
        for (OLTerm t: terms) {
            if (!t.isSatisfied(tuple)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (terms.size() == 0) {
            return "No predicates";
        }
        StringJoiner joiner = new StringJoiner(" AND ");
        for (OLTerm term: terms) {
            joiner.add(term.toString());
        }
        return joiner.toString();
    }
}
