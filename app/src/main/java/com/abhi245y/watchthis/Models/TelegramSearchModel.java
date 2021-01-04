package com.abhi245y.watchthis.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TelegramSearchModel implements Serializable {

    /**
     * ID : 306269
     * file_id : BQADBQADUQADnC1wV8q7_Mb0cmx4Ag
     * file_name : k g f chapter 1 2018 hindi 1080p mkv
     * caption : K.G.F Chapter 1 (2018) Hindi 1080p WEBrip HEVC 10bit AAC 6CH @PoOlLa (1.3 GB)
     * <p>
     * KGF 1080p WEBrip HEVC 10bit (1.3 GB)
     * Audio: #hindi AAC 6CH
     * Sub: english
     * imdb_link : http://www.imdb.com/title/tt7838252
     * mime_type : video/x-matroska
     * file_size : 1402827241
     * perma_link : https://t.me/pmudbdeivomargeletmoviedbdumppmu/152865
     */
    @SerializedName("ID")
    private String ID;
    @SerializedName("file_id")
    private String file_id;
    @SerializedName("file_name")
    private String file_name;
    @SerializedName("caption")
    private String caption;
    @SerializedName("imdb_link")
    private String imdb_link;
    @SerializedName("mime_type")
    private String mime_type;
    @SerializedName("file_size")
    private int file_size;
    @SerializedName("perma_link")
    private String perma_link;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImdb_link() {
        return imdb_link;
    }

    public void setImdb_link(String imdb_link) {
        this.imdb_link = imdb_link;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public String getPerma_link() {
        return perma_link;
    }

    public void setPerma_link(String perma_link) {
        this.perma_link = perma_link;
    }
}
