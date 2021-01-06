package com.abhi245y.watchthis.Models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OMDbMovieDetailsModel {


    /**
     * Title : Mulan
     * Year : 1998
     * Rated : G
     * Released : 19 Jun 1998
     * Runtime : 88 min
     * Genre : Animation, Adventure, Family, Fantasy, Musical, War
     * Director : Tony Bancroft, Barry Cook
     * Writer : Robert D. San Souci (based on a story by), Rita Hsiao (screenplay by), Chris Sanders (screenplay by), Philip LaZebnik (screenplay by), Raymond Singer (screenplay by), Eugenia Bostwick-Singer (screenplay by), Dean DeBlois (story co-head), John Sanford (story), Chris Williams (story), Tim Hodge (story), Julius Aguimatang (story), Burny Mattinson (story), Lorna Cook (story), Barry Johnson (story), Thom Enriquez (story), Ed Gombert (story), Joe Grant (story), Floyd Norman (story), Linda Woolverton (additional story material), Jodi Ann Johnson (additional story material), Alan Ormsby (additional story material), David Reynolds (additional story material), Don Dougherty (additional story material), Jorgen Klubien (additional story material), Denis Rich (additional story material), Joe Ekers (additional story material), Theodore Newton (additional story material), Larry Scholl (additional story material), Daan Jippes (additional story material), Frank Nissen (additional story material), Jeff Snow (additional story material)
     * Actors : Miguel Ferrer, Harvey Fierstein, Freda Foh Shen, June Foray
     * Plot : To save her father from death in the army, a young maiden secretly goes in his place and becomes one of China's greatest heroines in the process.
     * Language : English, Mandarin
     * Country : USA
     * Awards : Nominated for 1 Oscar. Another 17 wins & 20 nominations.
     * Poster : https://m.media-amazon.com/images/M/MV5BODkxNGQ1NWYtNzg0Ny00Yjg3LThmZTItMjE2YjhmZTQ0ODY5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg
     * Ratings : [{"Source":"Internet Movie Database","Value":"7.6/10"},{"Source":"Rotten Tomatoes","Value":"86%"},{"Source":"Metacritic","Value":"71/100"}]
     * Metascore : 71
     * imdbRating : 7.6
     * imdbVotes : 251,704
     * imdbID : tt0120762
     * Type : movie
     * DVD : N/A
     * BoxOffice : N/A
     * Production : Walt Disney Pictures, Walt Disney Animation
     * Website : N/A
     * Response : True
     */

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;
    private List<RatingsBean> Ratings;

    @NoArgsConstructor
    @Data
    public static class RatingsBean {
        /**
         * Source : Internet Movie Database
         * Value : 7.6/10
         */

        private String Source;
        private String Value;
    }
}
