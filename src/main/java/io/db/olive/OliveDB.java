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
                .bufferPoolSize(100)
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
                "create table students1 (id int, name varchar(20), isStudent boolean);"
            );
            createTable.execute(database, pool);
            
            createTable = OLParsingMachine.parse(
                "create table students2 (roll int, class int);"
            );
            createTable.execute(database, pool);

            createTable = OLParsingMachine.parse(
                "create table students3 (partner int);"
            );
            createTable.execute(database, pool);

            Random random = new Random();

            for (int i = 1; i <= 2; i++) {
                OLSQLBase insertTuple = OLParsingMachine.parse(
                    String.format(
                        "insert into students1 values (%d, \'%s\', %s);",
                        i, "test" + i,
                        random.nextBoolean()
                    )
                );
                insertTuple.execute(database, pool);
            }
            
            for (int i = 1; i <= 2; i++)
            {
                OLSQLBase insertTuple = OLParsingMachine.parse(
                    String.format(
                        "insert into students2 values (%d, %d);", 
                        i, random.nextInt(1, 13)
                    )
                );
                insertTuple.execute(database, pool);
            }

            for (int i = 1; i <= 2; i++)
            {
                OLSQLBase insertTuple = OLParsingMachine.parse(
                    String.format(
                        "insert into students3 values (%d);", 
                        i, random.nextInt(101)
                    )
                );
                insertTuple.execute(database, pool);
            }


            OLSQLBase stmt = OLParsingMachine.parse("select * from students1;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            stmt = OLParsingMachine.parse("select * from students2;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            stmt = OLParsingMachine.parse("select * from students1, students3;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            stmt = OLParsingMachine.parse("select * from students1, students2, students3 where roll = 2;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());
        
        } finally {
            database.dropDatabase();
        }
    }
}
