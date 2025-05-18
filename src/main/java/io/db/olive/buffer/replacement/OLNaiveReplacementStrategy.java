package io.db.olive.buffer.replacement;

import io.db.olive.buffer.OLBuffer;
import io.db.olive.buffer.OLBufferPool;

public class OLNaiveReplacementStrategy implements OLReplacementStrategy {
    private OLBufferPool pool;

    public OLNaiveReplacementStrategy(OLBufferPool pool) {
        this.pool = pool;
    }

    @Override
    public OLBuffer chooseBuffer() {
        for (OLBuffer buffer: pool.getBuffers()) {
            if (buffer.isReplaceable()) {
                return buffer;
            }
        }

        return null;
    }
    
}
