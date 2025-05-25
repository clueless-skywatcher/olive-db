package io.db.olive;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import io.db.olive.sql.OLSQLBase;
import io.db.olive.sql.OLVisitor;

public class OLParsingMachine {
    public static OLSQLBase parse(String stmt) {
        OLLexer lexer = new OLLexer(CharStreams.fromString(stmt));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        OL parser = new OL(tokenStream);
        ParseTree tree = parser.statement();
        OLSQLBase sql = new OLVisitor().visit(tree);
        return sql;
    }
}
