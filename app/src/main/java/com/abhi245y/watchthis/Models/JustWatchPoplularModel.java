package com.abhi245y.watchthis.Models;

import java.util.List;

public class JustWatchPoplularModel {

    /**
     * page_size : 5
     * total_pages : 400
     * total_results : 32428
     * items : [{"jw_entity_id":"tm138998","id":138998,"title":"Love","full_path":"/in/movie/love-2015","full_paths":{"MOVIE_DETAIL_OVERVIEW":"/in/movie/love-2015"},"poster":"/poster/10121239/{profile}","tmdb_popularity":4.965,"object_type":"movie","localized_release_date":"2019-05-31","scoring":[{"provider_type":"imdb:score","value":6.1},{"provider_type":"tmdb:popularity","value":4.965},{"provider_type":"tmdb:score","value":6.1},{"provider_type":"tmdb:id","value":292431}],"cinema_release_date":"2019-05-31"},{"jw_entity_id":"tm408218","id":408218,"title":"Greyhound","full_path":"/in/movie/greyhound","full_paths":{"MOVIE_DETAIL_OVERVIEW":"/in/movie/greyhound"},"poster":"/poster/188181053/{profile}","tmdb_popularity":71.091,"object_type":"movie","scoring":[{"provider_type":"tmdb:popularity","value":71.091},{"provider_type":"tmdb:id","value":516486},{"provider_type":"tmdb:score","value":7.5}]},{"jw_entity_id":"tm817035","id":817035,"title":"Lootcase","full_path":"/in/movie/lootcase","full_paths":{"MOVIE_DETAIL_OVERVIEW":"/in/movie/lootcase"},"poster":"/poster/196054477/{profile}","tmdb_popularity":7.234,"object_type":"movie","localized_release_date":"2020-04-10","scoring":[{"provider_type":"tmdb:id","value":635503},{"provider_type":"tmdb:score","value":5},{"provider_type":"tmdb:popularity","value":7.234}],"cinema_release_date":"2020-04-10"},{"jw_entity_id":"tm348502","id":348502,"title":"Moothon","full_path":"/in/movie/the-elder-one","full_paths":{"MOVIE_DETAIL_OVERVIEW":"/in/movie/the-elder-one"},"poster":"/poster/164953148/{profile}","tmdb_popularity":4.333,"object_type":"movie","localized_release_date":"2019-11-08","scoring":[{"provider_type":"imdb:score","value":8},{"provider_type":"tmdb:popularity","value":4.333},{"provider_type":"tmdb:score","value":7},{"provider_type":"tmdb:id","value":458012}],"cinema_release_date":"2019-11-08"},{"jw_entity_id":"tm141973","id":141973,"title":"The Fault in Our Stars","full_path":"/in/movie/the-fault-in-our-stars","full_paths":{"MOVIE_DETAIL_OVERVIEW":"/in/movie/the-fault-in-our-stars"},"poster":"/poster/9397999/{profile}","tmdb_popularity":19.512,"object_type":"movie","scoring":[{"provider_type":"tmdb:score","value":7.6},{"provider_type":"imdb:score","value":7.7},{"provider_type":"tmdb:id","value":222935},{"provider_type":"tmdb:popularity","value":19.512}]}]
     */

    private int page_size;
    private int total_pages;
    private int total_results;
    private List<ItemsBean> items;

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * jw_entity_id : tm138998
         * id : 138998
         * title : Love
         * full_path : /in/movie/love-2015
         * full_paths : {"MOVIE_DETAIL_OVERVIEW":"/in/movie/love-2015"}
         * poster : /poster/10121239/{profile}
         * tmdb_popularity : 4.965
         * object_type : movie
         * localized_release_date : 2019-05-31
         * scoring : [{"provider_type":"imdb:score","value":6.1},{"provider_type":"tmdb:popularity","value":4.965},{"provider_type":"tmdb:score","value":6.1},{"provider_type":"tmdb:id","value":292431}]
         * cinema_release_date : 2019-05-31
         */

        private String jw_entity_id;
        private int id;
        private String title;
        private String full_path;
        private FullPathsBean full_paths;
        private String poster;
        private double tmdb_popularity;
        private String object_type;
        private String localized_release_date;
        private String cinema_release_date;
        private List<ScoringBean> scoring;

        public String getJw_entity_id() {
            return jw_entity_id;
        }

        public void setJw_entity_id(String jw_entity_id) {
            this.jw_entity_id = jw_entity_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFull_path() {
            return full_path;
        }

        public void setFull_path(String full_path) {
            this.full_path = full_path;
        }

        public FullPathsBean getFull_paths() {
            return full_paths;
        }

        public void setFull_paths(FullPathsBean full_paths) {
            this.full_paths = full_paths;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public double getTmdb_popularity() {
            return tmdb_popularity;
        }

        public void setTmdb_popularity(double tmdb_popularity) {
            this.tmdb_popularity = tmdb_popularity;
        }

        public String getObject_type() {
            return object_type;
        }

        public void setObject_type(String object_type) {
            this.object_type = object_type;
        }

        public String getLocalized_release_date() {
            return localized_release_date;
        }

        public void setLocalized_release_date(String localized_release_date) {
            this.localized_release_date = localized_release_date;
        }

        public String getCinema_release_date() {
            return cinema_release_date;
        }

        public void setCinema_release_date(String cinema_release_date) {
            this.cinema_release_date = cinema_release_date;
        }

        public List<ScoringBean> getScoring() {
            return scoring;
        }

        public void setScoring(List<ScoringBean> scoring) {
            this.scoring = scoring;
        }

        public static class FullPathsBean {
            /**
             * MOVIE_DETAIL_OVERVIEW : /in/movie/love-2015
             */

            private String MOVIE_DETAIL_OVERVIEW;

            public String getMOVIE_DETAIL_OVERVIEW() {
                return MOVIE_DETAIL_OVERVIEW;
            }

            public void setMOVIE_DETAIL_OVERVIEW(String MOVIE_DETAIL_OVERVIEW) {
                this.MOVIE_DETAIL_OVERVIEW = MOVIE_DETAIL_OVERVIEW;
            }
        }

        public static class ScoringBean {
            /**
             * provider_type : imdb:score
             * value : 6.1
             */

            private String provider_type;
            private double value;

            public String getProvider_type() {
                return provider_type;
            }

            public void setProvider_type(String provider_type) {
                this.provider_type = provider_type;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }
        }
    }
}
