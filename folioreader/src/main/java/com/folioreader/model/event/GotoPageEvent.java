package com.folioreader.model.event;

/**
 * This event is used when web page in {@link com.folioreader.ui.fragment.FolioPageFragment}
 * is to reloaded.
 */
public class GotoPageEvent {
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
