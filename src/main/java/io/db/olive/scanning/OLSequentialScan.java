package io.db.olive.scanning;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBuffer;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLPage;
import io.db.olive.storage.OLStorageManager;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

import lombok.Getter;

public class OLSequentialScan implements OLScan {
    private @Getter String tableName;
    private OLBufferPool bufferPool;
    private int currentSlot;
    private OLDataFile tableFile;
    private OLPage currentPage;
    private long pageCount;
    private OLTupleSchema schema;
    private OLBuffer currentBuffer;

    public OLSequentialScan(
        String tableName, OLDatabase database, 
        OLBufferPool bufferPool
    ) throws Exception {
        this.tableName = tableName;
        this.schema = database.getSchema(tableName);
        OLStorageManager storageManager = database.getStorageManager();
        this.bufferPool = bufferPool;
        this.currentSlot = 0;
        this.tableFile = storageManager.startTableFile(tableName, schema);
        this.pageCount = tableFile.getPageCount();
        this.currentBuffer = bufferPool.readAndPinPage(tableFile, 0);
        this.currentPage = currentBuffer.getPage();
    }

    @Override
    public boolean hasNext() {
        return currentSlot < currentPage.getHeader().getSlotCounts() &&
            currentPage.getPageID().getId() < pageCount;
    }

    @Override
    public OLTuple next() throws Exception {
        byte[] tupleBytes = currentPage.readTupleBytes(currentSlot);
        if (tupleBytes == null) {
            return null;
        }

        OLTuple tuple = OLTuple.deserialize(tupleBytes, this.schema);
        if (currentSlot == currentPage.getHeader().getSlotCounts() - 1) {
            currentBuffer.unpin();
            currentBuffer = bufferPool.readAndPinPage(tableFile, currentPage.getPageID().getId() + 1);
            currentPage = currentBuffer.getPage();
            currentSlot = 0;
        } else {
            currentSlot++;
        }

        return tuple;
    }    

    public String toString() {
        return String.format("""
        SequentialScan on %s""", 
        tableName);
    }
}
