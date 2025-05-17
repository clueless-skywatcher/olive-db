package io.db.olive.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import lombok.Getter;

public class OLPage {
    private ByteBuffer content;
    private @Getter OLPageID pageID;
    private @Getter OLPageHeader header;

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
        int freeSpaceEnd = header.getFreeSpaceEnd();
        int freeSpaceStart = header.getFreeSpaceStart();
        if (freeSpaceEnd - freeSpaceStart < Integer.BYTES + tupleBytes.length) {
            return false;
        }

        int tupleInsertionPosition = freeSpaceEnd - tupleBytes.length;
        int offsetInsertionPosition = freeSpaceStart;

        content.position(tupleInsertionPosition);
        content.put(tupleBytes);
        content.position(offsetInsertionPosition);
        content.putInt(tupleInsertionPosition);

        header.setSlotCounts(slotCounts + 1);
        header.setFreeSpaceStart(freeSpaceStart + Integer.BYTES);
        header.setFreeSpaceEnd(tupleInsertionPosition);

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

    public byte[] readTupleBytes(int slotId) {
        int tupleSize = header.getTupleSize();

        if (slotId >= header.getSlotCounts()) {
            return null;
        }

        content.position(OLPageHeader.getSlotArrayOffset() + slotId * Integer.BYTES);
        int offset = content.getInt();
        content.position(offset);
        
        byte[] tuple = new byte[tupleSize];
        content.get(tuple);
        content.position(0);

        // If tuple is invalid return null
        if (tuple[0] == (byte) 0) {
            return null;            
        }
        
        return tuple;
    }
}
