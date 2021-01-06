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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public String getProduction() {
        return Production;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public List<RatingsBean> getRatings() {
        return Ratings;
    }

    public void setRatings(List<RatingsBean> ratings) {
        Ratings = ratings;
    }

    @NoArgsConstructor
    @Data
    public static class RatingsBean {
        /**
         * Source : Internet Movie Database
         * Value : 7.6/10
         */

        private String Source;
        private String Value;


        public String getSource() {
            return Source;
        }

        public void setSource(String source) {
            Source = source;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String value) {
            Value = value;
        }
    }
}
