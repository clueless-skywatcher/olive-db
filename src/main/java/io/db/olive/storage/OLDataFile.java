package io.db.olive.storage;

import java.io.File;

import lombok.Getter;

public class OLDataFile {
    private @Getter int pageSize;
    private File tableFile;

    public OLDataFile(File tableFile, int pageSize) {
        this.tableFile = tableFile;
        this.pageSize = pageSize;
    }

    public OLPage readPage(int id) throws Exception {
        OLPage page = new OLPage();
        page.readPage(tableFile, new OLPageID(id), pageSize);
        return page;
    }    
}
