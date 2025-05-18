package io.db.olive.buffer;

import io.db.olive.storage.OLDataFile;
import io.db.olive.storage.OLPage;
import io.db.olive.storage.OLPageID;
import lombok.Getter;

public class OLBuffer {
    private @Getter OLPage page;
    private @Getter int pins = 0;
    private @Getter OLDataFile file;

    public void loadPage(OLDataFile file, long id) throws Exception {
        loadPage(file, new OLPageID(id));
    }

    public void loadPage(OLDataFile file, OLPageID pageID) throws Exception {
        this.page = file.readPage(pageID.getId());
        this.file = file;
    }

    public void pin() {
        pins++;
    }

    public void unpin() {
        if (pins > 0) {
            pins--;
        }
    }

    public boolean isReplaceable() {
        return pins == 0;
    }

    public void flush() throws Exception {
        if (page != null) {
            file.writePage(page);
        }
    }
}
