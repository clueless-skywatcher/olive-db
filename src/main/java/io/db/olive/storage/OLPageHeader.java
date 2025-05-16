package io.db.olive.storage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class OLPageHeader {
    private @Getter @Setter int slotCounts;
    private @Getter @Setter int tupleSize;
    private @Getter @Setter int freeSpaceStart;
    private @Getter @Setter int freeSpaceEnd;

    public static int getSlotCountsOffset() {
        return 0;
    }

    public static int getTupleSizeOffset() {
        return getSlotCountsOffset() + Integer.BYTES;
    }

    public static int getFreeSpaceStartOffset() {
        return getTupleSizeOffset() + Integer.BYTES;
    }

    public static int getFreeSpaceEndOffset() {
        return getFreeSpaceStartOffset() + Integer.BYTES;
    }

    public static int getSlotArrayOffset() {
        return getFreeSpaceEndOffset() + Integer.BYTES;
    }
}
