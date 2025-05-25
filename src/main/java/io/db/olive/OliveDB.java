package io.db.olive;

import java.util.Random;

import java.io.File;
import java.nio.file.Paths;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.buffer.replacement.OLNaiveReplacementStrategy;
import io.db.olive.sql.OLSQLBase;

public class OliveDB {
    public static void main(String[] args) throws Exception {
        OLOptions options = OLOptions.builder()
                .pageSize(1024)
                .bufferPoolSize(5)
                .build();

        OLBufferPool pool = new OLBufferPool(options);
        pool.setStrategy(new OLNaiveReplacementStrategy(pool));

        File databaseDir = Paths.get(".olive", "data", "olive").toFile();
        OLDatabase database;
        
        if (!databaseDir.exists()) {
            database = OLDBInitializer.initialize("olive", options, pool);
        } else {
            database = new OLDatabase("olive", options, pool);
        }

        try {
            OLSQLBase createTable = OLParsingMachine.parse(
                "create table students (id int, name varchar(20), isStudent boolean);"
            );
            createTable.execute(database, pool);
            
            Random random = new Random();

            for (int i = 11; i <= 20; i++) {
                OLSQLBase insertTuple = OLParsingMachine.parse(
                    String.format(
                        "insert into students values (%d, \'%s\', %s);",
                        i, "test" + i,
                        random.nextBoolean()
                    )
                );

                insertTuple.execute(database, pool);
            }

            OLSQLBase stmt = OLParsingMachine.parse("select id, name, isStudent from students;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            OLSQLBase selectTables = OLParsingMachine.parse("select * from ol_tables;");
            selectTables.execute(database, pool);
            System.out.println(selectTables.getResult());

            selectTables = OLParsingMachine.parse("select * from ol_attributes;");
            selectTables.execute(database, pool);
            System.out.println(selectTables.getResult());
            
        } finally {
            database.dropDatabase();
        }
    }
}
