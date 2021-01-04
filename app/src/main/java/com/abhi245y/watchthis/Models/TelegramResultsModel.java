package com.abhi245y.watchthis.Models;

import java.io.Serializable;

public class TelegramResultsModel implements Serializable {
    String file_name,caption,link;
    int size;

    public TelegramResultsModel(String file_name, String caption, int size, String link) {
        this.file_name = file_name;
        this.caption = caption;
        this.size = size;
        this.link = link;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getCaption() {
        return caption;
    }

    public int getSize() {
        return size;
    }

    public String getLink() {
        return link;
    }
}
