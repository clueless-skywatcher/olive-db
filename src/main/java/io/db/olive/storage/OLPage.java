package io.db.olive.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import lombok.Getter;

/******************************************************* 
 * Class for handling a database file page.
 * 
 * A single page consists of the following parts
 * - A page header (16 bytes)
 * - A slot array
 * - Free space
 * - Tuples stored in the page
 * 
 * A page header consists of the following parts
 * - The number of occupied slots in the page (4 bytes)
 * - The size of a tuple stored in the page (4 bytes)
 * - The start position of the free space (4 bytes)
 * - The end position of the free space (4 bytes)
 * 
 * A slot array consists of the following parts for each tuple
 * stored in the page
 * - A unique ID for a tuple (4 bytes)
 * - A byte to denote whether the tuple is valid (not deleted)
 * - The offset where the tuple is actually stored (4 bytes)
 *  
 * During insertion, tuples are inserted at the end of the free 
 * space, and a slot entry is added at the beginning of the free 
 * space.
 * 
********************************************************/

public class OLPage {
    private ByteBuffer content;
    private @Getter OLPageID pageID;
    private @Getter OLPageHeader header;
    private int lastTupleId = 0;

    public void readPage(File file, int pageID, int pageSize) throws Exception {
        readPage(file, new OLPageID(pageID), pageSize);
    }

    public void readPage(File file, OLPageID pageID, int pageSize) throws Exception {
        this.pageID = pageID;
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(pageID.getId() * pageSize);
        byte[] content = new byte[pageSize];
        raf.read(content);
        this.content = ByteBuffer.wrap(content);
        raf.close();

        this.header = readHeader();
    }

    public void writePage(File file, int pageSize) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        raf.seek(pageID.getId() * pageSize);
        raf.write(getContent());
        raf.close();
    }

    public byte[] getContent() {
        return content.array();
    }

    private OLPageHeader readHeader() {
        content.position(0);
        int slotCounts = content.getInt();
        int tupleSize = content.getInt();
        int freeSpaceStart = content.getInt();
        int freeSpaceEnd = content.getInt();

        OLPageHeader header = OLPageHeader.builder()
            .slotCounts(slotCounts)
            .tupleSize(tupleSize)
            .freeSpaceStart(freeSpaceStart)
            .freeSpaceEnd(freeSpaceEnd)
            .build();

        return header;
    }

    /**
     * Attempt to insert a tuple to this page. Returns false if the 
     * insertion fails, and true otherwise
     * @param tuple
     * @return
     */

    public boolean insertTuple(byte[] tupleBytes) {
        int slotCounts = header.getSlotCounts();
        int freeSpaceStart = header.getFreeSpaceStart();
        int freeSpaceEnd = header.getFreeSpaceEnd();
        if (freeSpaceEnd - freeSpaceStart < Integer.BYTES * 2 + 1 + tupleBytes.length) {
            return false;
        }

        int tupleInsertionPosition = freeSpaceEnd - tupleBytes.length;
        int tupleIDInsertionPosition = freeSpaceStart;
        int validByteInsertionPosition = freeSpaceStart + Integer.BYTES;
        int offsetInsertionPosition = validByteInsertionPosition + 1;

        content.position(tupleIDInsertionPosition);
        content.putInt(lastTupleId);
        content.position(validByteInsertionPosition);
        content.put((byte) 1);
        content.position(offsetInsertionPosition);
        content.putInt(tupleInsertionPosition);
        content.position(tupleInsertionPosition);
        content.put(tupleBytes);
        
        header.setSlotCounts(slotCounts + 1);
        header.setFreeSpaceStart(freeSpaceStart + Integer.BYTES * 2 + 1);
        header.setFreeSpaceEnd(tupleInsertionPosition);

        lastTupleId++;

        updateHeader(header);

        return true;
    }

    private void updateHeader(OLPageHeader header) {
        content.position(OLPageHeader.getSlotCountsOffset());
        content.putInt(header.getSlotCounts());

        content.position(OLPageHeader.getFreeSpaceStartOffset());
        content.putInt(header.getFreeSpaceStart());

        content.position(OLPageHeader.getFreeSpaceEndOffset());
        content.putInt(header.getFreeSpaceEnd());

        content.position(0);
    }

    public void writeTupleBytes(int slotId, byte[] tupleBytes) {
        content.position(OLPageHeader.getSlotArrayOffset() + slotId * (Integer.BYTES * 2 + 1));
        content.getInt();
        byte isDirty = content.get();
        if (isDirty == (byte) 0) {
            return;
        }

        int offset = content.getInt();
        content.position(offset);
        content.put(tupleBytes);
        content.position(0);
    }

    public byte[] readTupleBytes(int slotId) {
        int tupleSize = header.getTupleSize();

        if (slotId >= header.getSlotCounts()) {
            return null;
        }

        content.position(OLPageHeader.getSlotArrayOffset() + slotId * (Integer.BYTES * 2 + 1));
        content.getInt();
        byte isDirty = content.get();

        if (isDirty == (byte) 0) {
            return null;
        }

        int offset = content.getInt();
        content.position(offset);

        byte[] tupleBytes = new byte[tupleSize];
        content.get(tupleBytes);
        
        ByteBuffer tupleBuffer = ByteBuffer.allocate(tupleSize);
        tupleBuffer.put(tupleBytes);

        content.position(0);

        return tupleBuffer.array();
    }
}
