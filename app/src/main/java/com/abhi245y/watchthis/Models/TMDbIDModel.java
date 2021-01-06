package com.abhi245y.watchthis.Models;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TMDbIDModel {

    /**
     * id : 10674
     * imdb_id : tt0120762
     * facebook_id : null
     * instagram_id : null
     * twitter_id : null
     */

    private Integer id;
    private String imdb_id;
    private Object facebook_id;
    private Object instagram_id;
    private Object twitter_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Object getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(Object facebook_id) {
        this.facebook_id = facebook_id;
    }

    public Object getInstagram_id() {
        return instagram_id;
    }

    public void setInstagram_id(Object instagram_id) {
        this.instagram_id = instagram_id;
    }

    public Object getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(Object twitter_id) {
        this.twitter_id = twitter_id;
    }
}

