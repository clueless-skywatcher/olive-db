package io.db.olive.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import io.db.olive.buffer.OLBuffer;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.tuples.OLTuple;
import lombok.Getter;
import lombok.Setter;

public class OLDataFile {
    private @Getter int pageSize;
    private @Getter File tableFile;
    private @Getter int tupleSize;
    private @Getter @Setter boolean readOnly;

    public OLDataFile(File tableFile, int pageSize, int tupleSize) throws Exception {
        this.tableFile = tableFile;
        this.pageSize = pageSize;
        this.tupleSize = tupleSize;
        this.readOnly = false;
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
        if (getPageCount() <= id && !readOnly) {
            addNewPage();
        }

        page.readPage(tableFile, new OLPageID(id), pageSize);
        return page;
    }  
    
    public void writePage(OLPage page) throws Exception {
        if (page.getContent().length == pageSize) {
            RandomAccessFile raf = new RandomAccessFile(tableFile, "rws");
            raf.seek(page.getPageID().getId() * pageSize);
            raf.write(page.getContent());
            raf.close();
        }
    }
    
    public long getPageCount() {
        return this.tableFile.length() / this.pageSize;
    }

    public void insertTuple(OLTuple tuple, OLBufferPool pool) throws Exception {
        OLBuffer lastPageBuffer = pool.readAndPinPage(this, getPageCount() - 1);
        byte[] tupleBytes = tuple.serialize();
        if (!lastPageBuffer.getPage().insertTuple(tupleBytes)) {
            addNewPage();
            lastPageBuffer.unpin();
            lastPageBuffer = pool.readAndPinPage(this, getPageCount() - 1);
            lastPageBuffer.getPage().insertTuple(tupleBytes);
        }
        lastPageBuffer.getPage().writePage(tableFile, pageSize);
        lastPageBuffer.unpin();
    }

    public boolean equals(Object file) {
        if (file instanceof OLDataFile) {
            OLDataFile dataFile = (OLDataFile) file;
            return dataFile.getTableFile().equals(getTableFile());
        }

        return false;
    }
}
