package com.abhi245y.watchthis.Extra;

import android.widget.ImageView;

import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;

public interface MovieItemClickListener {

    void onMovieClick(HomeHorizontalListModel movie_details,ImageView movieImage );
    void onSimilarMovieClick(SimilarMoviesListModel movie_details, ImageView movieImage);
    void AddMovieToList(ImageView favIcon,boolean isClicked);
}
