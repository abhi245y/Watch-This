package com.abhi245y.watchthis.Models;

public class SimilarMoviesListModel {

    String movieName, movieRating, thumbnailUrl;
    TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel;


    public SimilarMoviesListModel(String movieName, String movieRating, String thumbnailUrl, TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.thumbnailUrl = thumbnailUrl;
        this.tmDbSimilarMovieResultModel = tmDbSimilarMovieResultModel;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public TMDbSimilarMoviesModel.ResultsBean getTmDbSimilarMovieResultModel() {
        return tmDbSimilarMovieResultModel;
    }

    public void setTmDbSimilarMovieResultModel(TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel) {
        this.tmDbSimilarMovieResultModel = tmDbSimilarMovieResultModel;
    }
}
