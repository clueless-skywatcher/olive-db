package io.db.olive;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.buffer.replacement.OLNaiveReplacementStrategy;
import io.db.olive.sql.OLSQLBase;

public class OLMain {
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
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.err.print(">> ");
                String line = scanner.nextLine();
                if (!line.equals("!q")) {
                    OLSQLBase sql = OLParsingMachine.parse(line);
                    sql.execute(database, pool);
                    System.out.println(sql.getResult());
                } else {
                    break;
                }
            }
        } finally {
            scanner.close();
            database.dropDatabase();
        }
    }
}
