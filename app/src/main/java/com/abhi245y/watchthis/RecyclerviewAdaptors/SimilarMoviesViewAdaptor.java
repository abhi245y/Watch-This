package com.abhi245y.watchthis.RecyclerviewAdaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Extra.MovieItemClickListener;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;
import com.abhi245y.watchthis.Models.TMDbSimilarMoviesModel;
import com.abhi245y.watchthis.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SimilarMoviesViewAdaptor extends RecyclerView.Adapter<SimilarMoviesViewAdaptor.ViewHolder> {

    Context context;
    ArrayList<SimilarMoviesListModel> MovieDetails;
    TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel;
    MovieItemClickListener movieItemClickListener;

    public SimilarMoviesViewAdaptor(Context context, ArrayList<SimilarMoviesListModel> movieDetails, TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel, MovieItemClickListener listener) {
        this.context = context;
        MovieDetails = movieDetails;
        movieItemClickListener = listener;
        this.tmDbSimilarMovieResultModel = tmDbSimilarMovieResultModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimilarMoviesViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.similar_movie_list_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarMoviesViewAdaptor.ViewHolder holder, int position) {
        SimilarMoviesListModel movieInfo = MovieDetails.get(position);

        holder.movieName.setText(movieInfo.getMovieName());
        String rating = movieInfo.getMovieRating()+" %";
//        Log.d("SearchShows","TMDbSimilarMoviesModel.ResultsBean: "+movieInfo.getTmDbSimilarMovieResultModel());
        holder.movieRating.setText(rating);
        Glide.with(context).load(movieInfo.getThumbnailUrl()).fitCenter().into(holder.movieThumbnail);
    }

    @Override
    public int getItemCount() { return MovieDetails.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView movieThumbnail;
        TextView movieName, movieRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieThumbnail = itemView.findViewById(R.id.similar_movie_thumbnail);
            movieName = itemView.findViewById(R.id.similar_movie_name);
            movieRating = itemView.findViewById(R.id.similar_movie_rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onSimilarMovieClick(MovieDetails.get(getAdapterPosition()),movieThumbnail);
                }
            });
        }
    }
}
