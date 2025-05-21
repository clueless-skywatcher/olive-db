package io.db.olive.sql;

import io.db.olive.OL.SelectFromTableContext;
import io.db.olive.sql.dql.OLSelectFromTableSQL;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import io.db.olive.OLBaseVisitor;

public class OLVisitor extends OLBaseVisitor<OLSQLBase> {

    @Override
    public OLSelectFromTableSQL visitSelectFromTable(SelectFromTableContext ctx) {
        String tableName = ctx.tableName().getText();
        List<String> columnList = new ArrayList<>();
        if (ctx.ASTERISK() == null) {
            for (ParseTree pt: ctx.columnList().columnName()) {
                columnList.add(pt.getText());
            }
        }
        return new OLSelectFromTableSQL(tableName, columnList);
    }
    

}
