package io.db.olive;

import lombok.Builder;
import lombok.Getter;

@Builder
public class OLOptions {
    private @Getter int pageSize;
    private @Getter int bufferPoolSize;
}
