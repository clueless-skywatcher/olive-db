package io.db.olive.buffer.replacement;

import io.db.olive.buffer.OLBuffer;

public interface OLReplacementStrategy {
    public OLBuffer chooseBuffer();
}
