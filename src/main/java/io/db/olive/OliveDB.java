package io.db.olive;

import java.util.Random;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.buffer.replacement.OLNaiveReplacementStrategy;
import io.db.olive.sql.OLSQLBase;
import io.db.olive.tuples.OLTuple;

public class OliveDB {
    public static void main(String[] args) throws Exception {
        OLOptions options = OLOptions.builder()
                .pageSize(1024)
                .bufferPoolSize(5)
                .build();

        OLBufferPool pool = new OLBufferPool(options);
        pool.setStrategy(new OLNaiveReplacementStrategy(pool));

        OLDatabase database = OLDBInitializer.initialize("olive", options, pool);
        try {
            OLSQLBase createTable = OLParsingMachine.parse(
                "create table students (id int, name varchar(20), isStudent boolean);"
            );
            createTable.execute(database, pool);
            
            // Random random = new Random();

            // for (int i = 1; i <= 100; i++) {
            //     OLSQLBase insertTuple = OLParsingMachine.parse(
            //         String.format(
            //             "insert into students values (%d, \'%s\', %s);",
            //             i, "test" + i,
            //             random.nextBoolean()
            //         )
            //     );

            //     insertTuple.execute(database, pool);
            // }

            // OLSQLBase stmt = OLParsingMachine.parse("select id, name, isStudent from students;");
            // stmt.execute(database, pool);
            // for (OLTuple tuple: stmt.getResult().getTuples()) {
            //     System.out.println(tuple.toString());
            // }

            OLSQLBase selectTables = OLParsingMachine.parse("select * from ol_tables;");
            selectTables.execute(database, pool);
            for (OLTuple tuple: selectTables.getResult().getTuples()) {
                System.out.println(tuple.toString());
            }

            selectTables = OLParsingMachine.parse("select * from ol_attributes;");
            selectTables.execute(database, pool);
            for (OLTuple tuple: selectTables.getResult().getTuples()) {
                System.out.println(tuple.toString());
            }
        } finally {
            database.dropDatabase();
        }
    }
}
