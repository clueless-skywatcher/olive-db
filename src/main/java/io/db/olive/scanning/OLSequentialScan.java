package io.db.olive.scanning;

import java.nio.ByteBuffer;

import io.db.olive.OLDatabase;
import io.db.olive.buffer.OLBuffer;
import io.db.olive.buffer.OLBufferPool;
import io.db.olive.data.OLSerializable;
import io.db.olive.sql.OLPredicate;
import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLPage;
import io.db.olive.storage.OLStorageManager;
import io.db.olive.tuples.OLTuple;
import io.db.olive.tuples.OLTupleSchema;

import lombok.Getter;

public class OLSequentialScan implements OLWriteableScan {
    private @Getter String tableName;
    private OLBufferPool bufferPool;
    private int currentSlot;
    private OLDataFile tableFile;
    private OLPage currentPage;
    private long pageCount;
    private @Getter OLTupleSchema schema;
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

    public OLTuple getCurrentRow() {
        byte[] tupleBytes = currentPage.readTupleBytes(currentSlot);
        if (tupleBytes == null) {
            return null;
        }
        OLTuple tuple = OLTuple.deserialize(tupleBytes, this.schema);
        return tuple;
    }

    @Override
    public void next() throws Exception {
        if (currentSlot == currentPage.getHeader().getSlotCounts() - 1) {
            currentBuffer.unpin();
            currentBuffer = bufferPool.readAndPinPage(tableFile, currentPage.getPageID().getId() + 1);
            currentPage = currentBuffer.getPage();
            currentSlot = 0;
        } else {
            currentSlot++;
        }
    }    

    public String toString() {
        return toString("");
    }

    public String toString(String indent) {
        return String.format("""
        %sSequentialScan on %s""", 
        indent, tableName);
    }

    @Override
    public void update(OLPredicate predicate, String fieldName, OLSerializable<?> value) throws Exception {        
        OLTuple currentRow = getCurrentRow();
        if (currentRow == null) {
            return;
        }
        byte[] tupleBytes = currentRow.serialize();
        if (predicate.isSatisfied(currentRow)) {
            ByteBuffer buffer = ByteBuffer.wrap(tupleBytes);
            int offset = schema.getOffset(fieldName);
            buffer.position(offset);
            buffer.put(value.serialize());
            currentPage.writeTupleBytes(currentSlot, tupleBytes);
        }
    }

    @Override
    public void delete(OLPredicate predicate) throws Exception {
        OLTuple currentRow = getCurrentRow();
        if (currentRow == null) {
            return;
        }
        if (predicate.isSatisfied(currentRow)) {
            currentPage.markInvalid(currentSlot);
        }
    }
}
