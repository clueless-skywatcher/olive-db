package io.db.olive.sql;

import io.db.olive.OL;
import io.db.olive.OL.InsertIntoTableContext;
import io.db.olive.data.OLBoolean;
import io.db.olive.data.OLCappedChar;
import io.db.olive.data.OLInteger;
import io.db.olive.data.OLSerializable;
import io.db.olive.data.info.OLBooleanInfo;
import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLDataInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.sql.ddl.OLCreateTableSQL;
import io.db.olive.sql.dml.OLInsertIntoTableSQL;
import io.db.olive.sql.dql.OLSelectFromTableSQL;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import io.db.olive.OLBaseVisitor;

public class OLVisitor extends OLBaseVisitor<OLSQLBase> {

    @Override
    public OLSelectFromTableSQL visitSelectFromTable(OL.SelectFromTableContext ctx) {
        String tableName = ctx.tableName().getText();
        List<String> columnList = new ArrayList<>();
        if (ctx.ASTERISK() == null) {
            for (ParseTree pt: ctx.columnList().columnName()) {
                columnList.add(pt.getText());
            }
        }

        OLPredicate predicate = new OLPredicate();

        if (ctx.condition() != null) {
            for (OL.ExpressionContext expression: ctx.condition().expression()) {
                if (expression.term() != null) {
                    String columnName = expression.term().columnName().getText();
                    OL.ValueContext valueContext = expression.term().value();
                    OLSerializable<?> val;
                    if (valueContext.INTEGER() != null) {
                        int intVal = Integer.parseInt(valueContext.getText());
                        val = new OLInteger(intVal);
                    } else if (valueContext.BOOLVALUE() != null) {
                        boolean boolVal = Boolean.parseBoolean(valueContext.getText());
                        val = new OLBoolean(boolVal);
                    } else {
                        String strVal = valueContext.getText();
                        strVal = strVal.substring(1, strVal.length() - 1);
                        val = new OLCappedChar(strVal, strVal.length());
                    }

                    predicate.addTerm(new OLTerm(columnName, val));
                }
            }
        }

        return new OLSelectFromTableSQL(tableName, columnList, predicate, ctx.getText());
    }

    @Override
    public OLSQLBase visitCreateTable(OL.CreateTableContext ctx) {
        String tableName = ctx.tableName().getText();
        Map<String, OLDataInfo> columnMap = new LinkedHashMap<>();

        for (OL.ColumnDefinitionContext columnDef: ctx.columnDefinition()) {
            String columnName = columnDef.columnName().getText();
            OL.DataTypeContext dataType = columnDef.dataType();
            OLDataInfo info;

            if (dataType.intType() != null) {
                info = new OLIntegerInfo();
            } else if (dataType.varcharType() != null) {
                int charLength = Integer.parseInt(dataType.varcharType().charLength.getText());
                info = new OLCappedCharInfo(charLength);
            } else {
                info = new OLBooleanInfo();
            }

            columnMap.put(columnName, info);
        }

        return new OLCreateTableSQL(tableName, columnMap, ctx.getText());
    }

    @Override
    public OLSQLBase visitInsertIntoTable(InsertIntoTableContext ctx) {
        String tableName = ctx.tableName().getText();
        Map<String, String> values = new LinkedHashMap<>();

        if (ctx.columnList() != null) {
            List<OL.ValueContext> valueContexts = ctx.valueList().value();
            for (int i = 0; i < valueContexts.size(); i++) {
                String columnName = ctx.columnList().columnName(i).getText();
                String valueContext = valueContexts.get(i).getText();

                values.put(columnName, valueContext);
            }
            return new OLInsertIntoTableSQL(tableName, values, ctx.getText());
        } else {
            List<String> valueList = new ArrayList<>();
            for (OL.ValueContext value: ctx.valueList().value()) {
                valueList.add(value.getText());
            }  

            return new OLInsertIntoTableSQL(tableName, valueList, ctx.getText());
        }
    }

    
}
