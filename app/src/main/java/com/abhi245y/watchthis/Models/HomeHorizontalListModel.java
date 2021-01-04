package com.abhi245y.watchthis.Models;

import java.util.ArrayList;

public class HomeHorizontalListModel {
    String title_name,poster_url,rating,release_year,overview,backdrop_url,ImdbId,genresOMDb;
    ArrayList<Integer> genres;
    int TMDb_Id;

    public HomeHorizontalListModel(){

    }

    public HomeHorizontalListModel(String title_name, String poster_url, String rating, String release_year, String overview, String backdrop_url, ArrayList<Integer> genres, int TMDb_Id) {
        this.title_name = title_name;
        this.poster_url = poster_url;
        this.rating = rating;
        this.release_year = release_year;
        this.overview = overview;
        this.backdrop_url = backdrop_url;
        this.genres = genres;
        this.TMDb_Id = TMDb_Id;
    }

    public HomeHorizontalListModel(String title_name, String poster_url, String rating, String release_year) {
        this.title_name = title_name;
        this.poster_url = poster_url;
        this.rating = rating;
        this.release_year = release_year;

    }

    public HomeHorizontalListModel(String title_name, String poster_url, String rating, String release_year, String overview) {
        this.title_name = title_name;
        this.poster_url = poster_url;
        this.rating = rating;
        this.release_year = release_year;
        this.overview = overview;
    }

    public HomeHorizontalListModel(String title_name, String poster_url, String rating, String release_year, String overview, String imdbId, String genresOMDb) {
        this.title_name = title_name;
        this.poster_url = poster_url;
        this.rating = rating;
        this.release_year = release_year;
        this.overview = overview;
        this.ImdbId = imdbId;
        this.genresOMDb = genresOMDb;
    }

    public String getImdbId() {
        return ImdbId;
    }

    public ArrayList<Integer> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Integer> genres) {
        this.genres = genres;
    }

    public String getGenresOMDb() {
        return genresOMDb;
    }

    public String getBackdrop_url() {
        return backdrop_url;
    }

    public void setBackdrop_url(String backdrop_url) {
        this.backdrop_url = backdrop_url;
    }

    public int getTMDb_Id() {
        return TMDb_Id;
    }

    public void setTMDb_Id(int TMDb_Id) {
        this.TMDb_Id = TMDb_Id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }
}
