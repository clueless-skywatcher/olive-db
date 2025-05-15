package io.db.olive;

/**
 * Hello world!
 *
 */
public class OliveDB
{
    public static void main(String[] args) throws Exception
    {
        OLOptions options = OLOptions.builder()
            .pageSize(1024)
            .build();
        OLDatabase database = new OLDatabase("meta", options);
        database.createTable("tables_meta");
    }
}
