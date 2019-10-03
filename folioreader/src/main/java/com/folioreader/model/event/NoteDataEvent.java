package com.folioreader.model.event;

import com.folioreader.model.HighlightImpl;
import com.folioreader.model.HighlightImpl.HighlightStyle;

/**
 * This event is used when web page in {@link com.folioreader.ui.fragment.FolioPageFragment}
 * is to reloaded.
 */
public class NoteDataEvent {
    private String textNotes;
    private HighlightStyle pickedHighlightStyle;

    public String getTextNotes() {
        return textNotes;
    }

    public void setTextNotes(String textNotes) {
        this.textNotes = textNotes;
    }

    public HighlightStyle getPickedHighlightStyle() {
        return pickedHighlightStyle;
    }

    public void setPickedHighlightStyle(HighlightStyle pickedHighlightStyle) {
        this.pickedHighlightStyle = pickedHighlightStyle;
    }
}
