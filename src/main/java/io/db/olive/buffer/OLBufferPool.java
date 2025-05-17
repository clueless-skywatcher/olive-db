package io.db.olive.buffer;

import io.db.olive.buffer.replacement.OLReplacementStrategy;
import io.db.olive.storage.OLDataFile;
import lombok.Getter;

public class OLBufferPool {
    private @Getter OLBuffer[] buffers;
    private @Getter OLReplacementStrategy strategy;
    private @Getter int availableBuffers;

    public OLBufferPool(int bufferCount, OLReplacementStrategy strategy) {
        buffers = new OLBuffer[bufferCount];
        for (int i = 0; i < bufferCount; i++) {
            buffers[i] = new OLBuffer();
        }
        this.strategy = strategy;
        this.availableBuffers = bufferCount;
    }

    private OLBuffer findBufferHoldingPage(OLDataFile file, long pageID) {
        for (OLBuffer buffer: buffers) {
            if (buffer.getPageId().getId() == pageID && buffer.getFile().equals(file)) {
                return buffer;
            }
        }

        return null;
    }

    public void unpinBuffer(OLBuffer buffer) {
        buffer.unpin();
        if (buffer.isReplaceable()) {
            availableBuffers++;
        }
    }

    public OLBuffer readAndPinPage(OLDataFile file, long pageID) throws Exception {
        OLBuffer buffer = findBufferHoldingPage(file, pageID);
        
        // No buffers found that hold the page, have to replace
        if (buffer == null) {
            buffer = strategy.chooseBuffer();
            buffer.loadPage(file, pageID);
        }

        if (buffer.isReplaceable()) {
            availableBuffers--;
        }

        buffer.pin();
        return buffer;
    }

    public void flushAll() throws Exception {
        for (OLBuffer buffer: buffers) {
            buffer.flush();
        }
    }
}
