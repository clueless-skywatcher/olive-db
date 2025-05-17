package io.db.olive.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import io.db.olive.tuples.OLTuple;
import lombok.Getter;

public class OLDataFile {
    private @Getter int pageSize;
    private @Getter File tableFile;
    private @Getter int tupleSize;

    public OLDataFile(File tableFile, int pageSize, int tupleSize) throws Exception {
        this.tableFile = tableFile;
        this.pageSize = pageSize;
        this.tupleSize = tupleSize;

        // If file is new, add a new page
        if (this.tableFile.createNewFile() || this.tableFile.length() == 0) {
            addNewPage();
        }
    }

    private void addNewPage() throws Exception {
        RandomAccessFile raf = new RandomAccessFile(tableFile, "rws");
        raf.seek(raf.length());
        
        ByteBuffer buffer = ByteBuffer.allocate(pageSize);
        buffer.putInt(0); // Add slot on header
        buffer.putInt(tupleSize); // Add tuple size on header
        buffer.putInt(Integer.BYTES * 4); // Add free space start on header
        buffer.putInt(pageSize); // Add free space end on header;

        raf.write(buffer.array());
        raf.close();
    }

    public OLPage readPage(long id) throws Exception {
        OLPage page = new OLPage();
        if (getPageCount() <= id) {
            addNewPage();
        }

        page.readPage(tableFile, new OLPageID(id), pageSize);
        return page;
    }   
    
    public long getPageCount() {
        return this.tableFile.length() / this.pageSize;
    }

    public void insertTuple(OLTuple tuple) throws Exception {
        OLPage lastPage = readPage(getPageCount() - 1);
        byte[] tupleBytes = tuple.serialize();
        if (!lastPage.insertTuple(tupleBytes)) {
            addNewPage();
            lastPage = readPage(getPageCount() - 1);
            lastPage.insertTuple(tupleBytes);
        }
        lastPage.writePage(tableFile, pageSize);
    }
}
