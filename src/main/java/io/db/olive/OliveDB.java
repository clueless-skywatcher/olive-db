package io.db.olive;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
            
            Random random = new Random();
            Set<Integer> idSet = new HashSet<>();
            for (int i = 1; i <= 10; i++) {
                int val = random.nextInt(1, 101);
                while (idSet.contains(val)) {
                    val = random.nextInt(1, 101);
                }
                idSet.add(val);
                String stmt = String.format(
                    "insert into students1 values (%d, \'%s\', %s);",
                    val, "test" + val,
                    random.nextBoolean()
                );
                OLSQLBase insertTuple = OLParsingMachine.parse(stmt);
                insertTuple.execute(database, pool);
                System.out.println(stmt);
            }

            OLSQLBase stmt = OLParsingMachine.parse("select * from students1;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            // stmt = OLParsingMachine.parse("select * from students2;");
            // stmt.execute(database, pool);
            // System.out.println(stmt.getResult());

            stmt = OLParsingMachine.parse("select * from students1;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());

            stmt = OLParsingMachine.parse("select * from students1 order by id;");
            stmt.execute(database, pool);
            System.out.println(stmt.getResult());
        } finally {
            database.dropDatabase();
        }
    }
}
