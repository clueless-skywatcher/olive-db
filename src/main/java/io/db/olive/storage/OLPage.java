package io.db.olive.storage;

import java.io.File;
import java.io.RandomAccessFile;

import lombok.Getter;

public class OLPage {
    private @Getter byte[] content;
    private @Getter OLPageID pageID;
    private @Getter OLPageHeader header;

    public void readPage(File file, OLPageID pageID, int pageSize) throws Exception {
        this.pageID = pageID;
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(pageID.getId());
        byte[] content = new byte[pageSize];
        raf.read(content);
        this.content = content;
        raf.close();
    }
}
