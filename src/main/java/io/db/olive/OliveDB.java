package io.db.olive;

import io.db.olive.data.OLCappedChar;
import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.data.OLInteger;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

/**
 * Hello world!
 *
 */
public class OliveDB
{
    public static void main(String[] args) throws Exception
    {
        // OLOptions options = OLOptions.builder()
        //     .pageSize(1024)
        //     .build();
        // OLDatabase database = new OLDatabase("meta", options);
        // database.createTable("tables_meta");

        OLTupleSchema schema = new OLTupleSchema();
        schema.addField("name", new OLCappedCharInfo(10));
        schema.addField("id", new OLIntegerInfo());
        OLTuple tuple = new OLTuple(schema);
        tuple.addField("name", new OLCappedChar("test", 10));
        tuple.addField("id", new OLInteger(1));
        System.out.println(tuple.toString());
    }
}
