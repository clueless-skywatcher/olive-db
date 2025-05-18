package io.db.olive;

import java.util.List;

import io.db.olive.buffer.OLBufferPool;
import io.db.olive.buffer.replacement.OLNaiveReplacementStrategy;
import io.db.olive.data.OLCappedChar;
import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.data.OLInteger;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

public class OliveDB {
    public static void main(String[] args) throws Exception {
        OLOptions options = OLOptions.builder()
                .pageSize(1024)
                .build();
        OLDatabase database = new OLDatabase("personal", options);
        OLBufferPool pool = new OLBufferPool(5);
        pool.setStrategy(new OLNaiveReplacementStrategy(pool));

        try {
            OLTupleSchema schema = new OLTupleSchema();
            schema.addField("name", new OLCappedCharInfo(10));
            schema.addField("id", new OLIntegerInfo());

            System.out.println(schema.getSize());

            database.createTable("students", schema);

            for (int i = 1; i <= 100; i++) {
                OLTuple tuple1 = new OLTuple(schema);
                tuple1.addField("name", new OLCappedChar("test" + i, 10));
                tuple1.addField("id", new OLInteger(i));
                database.insertTuple("students", tuple1, pool);
            }

            List<OLTuple> tuples = database.selectAllTuples("students", schema, pool);
            for (OLTuple tuple : tuples) {
                System.out.println(tuple.toString());
            }
        } finally {
            database.dropDatabase();
        }

    }
}
