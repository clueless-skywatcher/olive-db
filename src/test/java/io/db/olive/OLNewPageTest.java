package io.db.olive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.db.olive.data.info.OLCappedCharInfo;
import io.db.olive.data.info.OLIntegerInfo;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLPage;
import io.db.olive.storage.OLPageID;
import io.db.olive.tuples.OLTupleSchema;

public class OLNewPageTest {
    @Test
    public void testNewPageHeader() throws Exception {
        int pageSize = 1024;
        OLOptions options = OLOptions.builder()
            .pageSize(pageSize)
            .build();
        OLDatabase db = new OLDatabase("test", options);
        OLTupleSchema schema = new OLTupleSchema();
        schema.addField("name", new OLCappedCharInfo(10));
        schema.addField("id", new OLIntegerInfo());
        OLDataFile file = db.createTable("test_table1", schema);
        OLPage page = new OLPage();
        page.readPage(file.getTableFile(), new OLPageID(0), pageSize);

        assertEquals(page.getHeader().getSlotCounts(), 0);
        assertEquals(page.getHeader().getFreeSpaceStart(), 0);
        assertEquals(page.getHeader().getFreeSpaceEnd(), pageSize - 1);
        assertEquals(page.getHeader().getTupleSize(), schema.getSize());

        db.dropDatabase();        
    }
}
