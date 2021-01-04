package com.abhi245y.watchthis.Models;

import java.util.List;

// FIXME generate failure  field _$Meta2
public class YTSSearchModel {

    /**
     * status : ok
     * status_message : Query was successful
     * data : {"movie_count":1,"limit":20,"page_number":1,"movies":[{"id":20314,"url":"https://yts.mx/movies/love-at-first-glance-2017","imdb_code":"tt6338374","title":"Love at First Glance","title_english":"Love at First Glance","title_long":"Love at First Glance (2017)","slug":"love-at-first-glance-2017","year":2017,"rating":6.1,"runtime":0,"genres":["Drama","Romance"],"summary":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","description_full":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","synopsis":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","yt_trailer_code":"hqgtOQ5ZVVM","language":"English","mpa_rating":"","background_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg","background_image_original":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg","small_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/small-cover.jpg","medium_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/medium-cover.jpg","large_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/large-cover.jpg","state":"ok","torrents":[{"url":"https://yts.mx/torrent/download/F8E988F23E3717A81DB63325CE520DE15220B862","hash":"F8E988F23E3717A81DB63325CE520DE15220B862","quality":"720p","type":"web","seeds":98,"peers":72,"size":"795.76 MB","size_bytes":834414838,"date_uploaded":"2020-08-19 21:19:47","date_uploaded_unix":1597864787},{"url":"https://yts.mx/torrent/download/F460749BAFEEFCDC297E01F99573415A1550BAE9","hash":"F460749BAFEEFCDC297E01F99573415A1550BAE9","quality":"1080p","type":"web","seeds":83,"peers":44,"size":"1.6 GB","size_bytes":1717986918,"date_uploaded":"2020-08-19 23:32:43","date_uploaded_unix":1597872763}],"date_uploaded":"2020-08-19 21:19:47","date_uploaded_unix":1597864787}]}
     * @meta : {"server_time":1597943821,"server_timezone":"CET","api_version":2,"execution_time":"0 ms"}
     */

    private String status;
    private String status_message;
    private DataBean data;

    public static class DataBean {
        /**
         * movie_count : 1
         * limit : 20
         * page_number : 1
         * movies : [{"id":20314,"url":"https://yts.mx/movies/love-at-first-glance-2017","imdb_code":"tt6338374","title":"Love at First Glance","title_english":"Love at First Glance","title_long":"Love at First Glance (2017)","slug":"love-at-first-glance-2017","year":2017,"rating":6.1,"runtime":0,"genres":["Drama","Romance"],"summary":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","description_full":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","synopsis":"A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.","yt_trailer_code":"hqgtOQ5ZVVM","language":"English","mpa_rating":"","background_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg","background_image_original":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg","small_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/small-cover.jpg","medium_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/medium-cover.jpg","large_cover_image":"https://yts.mx/assets/images/movies/love_at_first_glance_2017/large-cover.jpg","state":"ok","torrents":[{"url":"https://yts.mx/torrent/download/F8E988F23E3717A81DB63325CE520DE15220B862","hash":"F8E988F23E3717A81DB63325CE520DE15220B862","quality":"720p","type":"web","seeds":98,"peers":72,"size":"795.76 MB","size_bytes":834414838,"date_uploaded":"2020-08-19 21:19:47","date_uploaded_unix":1597864787},{"url":"https://yts.mx/torrent/download/F460749BAFEEFCDC297E01F99573415A1550BAE9","hash":"F460749BAFEEFCDC297E01F99573415A1550BAE9","quality":"1080p","type":"web","seeds":83,"peers":44,"size":"1.6 GB","size_bytes":1717986918,"date_uploaded":"2020-08-19 23:32:43","date_uploaded_unix":1597872763}],"date_uploaded":"2020-08-19 21:19:47","date_uploaded_unix":1597864787}]
         */

        private int movie_count;
        private int limit;
        private int page_number;
        private java.util.List<MoviesBean> movies;

        public int getMovie_count() {
            return movie_count;
        }

        public void setMovie_count(int movie_count) {
            this.movie_count = movie_count;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPage_number() {
            return page_number;
        }

        public void setPage_number(int page_number) {
            this.page_number = page_number;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * id : 20314
             * url : https://yts.mx/movies/love-at-first-glance-2017
             * imdb_code : tt6338374
             * title : Love at First Glance
             * title_english : Love at First Glance
             * title_long : Love at First Glance (2017)
             * slug : love-at-first-glance-2017
             * year : 2017
             * rating : 6.1
             * runtime : 0
             * genres : ["Drama","Romance"]
             * summary : A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.
             * description_full : A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.
             * synopsis : A young woman's hope for an engagement is upended unexpectedly when her fiancé tells her he is looking for someone more adventurous. On her train ride home, she finds herself trading glances with a handsome stranger who, as he exits the train, leaves his phone behind. As she endeavors to return the phone, she finds herself on a journey of self-discovery.
             * yt_trailer_code : hqgtOQ5ZVVM
             * language : English
             * mpa_rating :
             * background_image : https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg
             * background_image_original : https://yts.mx/assets/images/movies/love_at_first_glance_2017/background.jpg
             * small_cover_image : https://yts.mx/assets/images/movies/love_at_first_glance_2017/small-cover.jpg
             * medium_cover_image : https://yts.mx/assets/images/movies/love_at_first_glance_2017/medium-cover.jpg
             * large_cover_image : https://yts.mx/assets/images/movies/love_at_first_glance_2017/large-cover.jpg
             * state : ok
             * torrents : [{"url":"https://yts.mx/torrent/download/F8E988F23E3717A81DB63325CE520DE15220B862","hash":"F8E988F23E3717A81DB63325CE520DE15220B862","quality":"720p","type":"web","seeds":98,"peers":72,"size":"795.76 MB","size_bytes":834414838,"date_uploaded":"2020-08-19 21:19:47","date_uploaded_unix":1597864787},{"url":"https://yts.mx/torrent/download/F460749BAFEEFCDC297E01F99573415A1550BAE9","hash":"F460749BAFEEFCDC297E01F99573415A1550BAE9","quality":"1080p","type":"web","seeds":83,"peers":44,"size":"1.6 GB","size_bytes":1717986918,"date_uploaded":"2020-08-19 23:32:43","date_uploaded_unix":1597872763}]
             * date_uploaded : 2020-08-19 21:19:47
             * date_uploaded_unix : 1597864787
             */

            private int id;
            private String url;
            private String imdb_code;
            private String title;
            private String title_english;
            private String title_long;
            private String slug;
            private int year;
            private double rating;
            private int runtime;
            private String summary;
            private String description_full;
            private String synopsis;
            private String yt_trailer_code;
            private String language;
            private String mpa_rating;
            private String background_image;
            private String background_image_original;
            private String small_cover_image;
            private String medium_cover_image;
            private String large_cover_image;
            private String state;
            private String date_uploaded;
            private int date_uploaded_unix;
            private java.util.List<String> genres;
            private java.util.List<TorrentsBean> torrents;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImdb_code() {
                return imdb_code;
            }

            public void setImdb_code(String imdb_code) {
                this.imdb_code = imdb_code;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle_english() {
                return title_english;
            }

            public void setTitle_english(String title_english) {
                this.title_english = title_english;
            }

            public String getTitle_long() {
                return title_long;
            }

            public void setTitle_long(String title_long) {
                this.title_long = title_long;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public double getRating() {
                return rating;
            }

            public void setRating(double rating) {
                this.rating = rating;
            }

            public int getRuntime() {
                return runtime;
            }

            public void setRuntime(int runtime) {
                this.runtime = runtime;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getDescription_full() {
                return description_full;
            }

            public void setDescription_full(String description_full) {
                this.description_full = description_full;
            }

            public String getSynopsis() {
                return synopsis;
            }

            public void setSynopsis(String synopsis) {
                this.synopsis = synopsis;
            }

            public String getYt_trailer_code() {
                return yt_trailer_code;
            }

            public void setYt_trailer_code(String yt_trailer_code) {
                this.yt_trailer_code = yt_trailer_code;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getMpa_rating() {
                return mpa_rating;
            }

            public void setMpa_rating(String mpa_rating) {
                this.mpa_rating = mpa_rating;
            }

            public String getBackground_image() {
                return background_image;
            }

            public void setBackground_image(String background_image) {
                this.background_image = background_image;
            }

            public String getBackground_image_original() {
                return background_image_original;
            }

            public void setBackground_image_original(String background_image_original) {
                this.background_image_original = background_image_original;
            }

            public String getSmall_cover_image() {
                return small_cover_image;
            }

            public void setSmall_cover_image(String small_cover_image) {
                this.small_cover_image = small_cover_image;
            }

            public String getMedium_cover_image() {
                return medium_cover_image;
            }

            public void setMedium_cover_image(String medium_cover_image) {
                this.medium_cover_image = medium_cover_image;
            }

            public String getLarge_cover_image() {
                return large_cover_image;
            }

            public void setLarge_cover_image(String large_cover_image) {
                this.large_cover_image = large_cover_image;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getDate_uploaded() {
                return date_uploaded;
            }

            public void setDate_uploaded(String date_uploaded) {
                this.date_uploaded = date_uploaded;
            }

            public int getDate_uploaded_unix() {
                return date_uploaded_unix;
            }

            public void setDate_uploaded_unix(int date_uploaded_unix) {
                this.date_uploaded_unix = date_uploaded_unix;
            }

            public List<String> getGenres() {
                return genres;
            }

            public void setGenres(List<String> genres) {
                this.genres = genres;
            }

            public List<TorrentsBean> getTorrents() {
                return torrents;
            }

            public void setTorrents(List<TorrentsBean> torrents) {
                this.torrents = torrents;
            }

            public static class TorrentsBean {
                /**
                 * url : https://yts.mx/torrent/download/F8E988F23E3717A81DB63325CE520DE15220B862
                 * hash : F8E988F23E3717A81DB63325CE520DE15220B862
                 * quality : 720p
                 * type : web
                 * seeds : 98
                 * peers : 72
                 * size : 795.76 MB
                 * size_bytes : 834414838
                 * date_uploaded : 2020-08-19 21:19:47
                 * date_uploaded_unix : 1597864787
                 */

                private String url;
                private String hash;
                private String quality;
                private String type;
                private int seeds;
                private int peers;
                private String size;
                private int size_bytes;
                private String date_uploaded;
                private int date_uploaded_unix;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSeeds() {
                    return seeds;
                }

                public void setSeeds(int seeds) {
                    this.seeds = seeds;
                }

                public int getPeers() {
                    return peers;
                }

                public void setPeers(int peers) {
                    this.peers = peers;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public int getSize_bytes() {
                    return size_bytes;
                }

                public void setSize_bytes(int size_bytes) {
                    this.size_bytes = size_bytes;
                }

                public String getDate_uploaded() {
                    return date_uploaded;
                }

                public void setDate_uploaded(String date_uploaded) {
                    this.date_uploaded = date_uploaded;
                }

                public int getDate_uploaded_unix() {
                    return date_uploaded_unix;
                }

                public void setDate_uploaded_unix(int date_uploaded_unix) {
                    this.date_uploaded_unix = date_uploaded_unix;
                }
            }
        }
    }
}
