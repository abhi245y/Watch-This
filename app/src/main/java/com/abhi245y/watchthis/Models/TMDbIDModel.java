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
}

