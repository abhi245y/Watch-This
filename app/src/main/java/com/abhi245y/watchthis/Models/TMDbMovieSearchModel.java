package com.abhi245y.watchthis.Models;

import java.util.ArrayList;

public class TMDbMovieSearchModel {

    /**
     * page : 1
     * total_results : 1
     * total_pages : 1
     * results : [{"popularity":3.511,"id":458012,"video":false,"vote_count":9,"vote_average":7,"title":"Moothon","release_date":"2019-10-18","original_language":"ml","original_title":"മൂത്തോന്\u200d","genre_ids":[80,18],"backdrop_path":"/aBGWvhAaWvCxX7iM2pHj5rWy4Zd.jpg","adult":false,"overview":"A 10 year old boy living on an island sets off on a journey in pursuit of Akbar, his long lost elder brother.","poster_path":"/wyyHGE5uHgUFDUKDHzO6TGq6EJs.jpg"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private ArrayList<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<ResultsBean> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * popularity : 3.511
         * id : 458012
         * video : false
         * vote_count : 9
         * vote_average : 7
         * title : Moothon
         * release_date : 2019-10-18
         * original_language : ml
         * original_title : മൂത്തോന്‍
         * genre_ids : [80,18]
         * backdrop_path : /aBGWvhAaWvCxX7iM2pHj5rWy4Zd.jpg
         * adult : false
         * overview : A 10 year old boy living on an island sets off on a journey in pursuit of Akbar, his long lost elder brother.
         * poster_path : /wyyHGE5uHgUFDUKDHzO6TGq6EJs.jpg
         */

        private double popularity;
        private int id;
        private boolean video;
        private float vote_count;
        private float vote_average;
        private String title;
        private String release_date;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String poster_path;
        private ArrayList<Integer> genre_ids;

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public float getVote_count() {
            return vote_count;
        }

        public void setVote_count(float vote_count) {
            this.vote_count = vote_count;
        }

        public float getVote_average() {
            return vote_average;
        }

        public void setVote_average(int vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public ArrayList<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(ArrayList<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
