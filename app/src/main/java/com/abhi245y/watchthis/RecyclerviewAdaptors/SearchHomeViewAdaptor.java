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
import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
import com.abhi245y.watchthis.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SearchHomeViewAdaptor extends RecyclerView.Adapter<SearchHomeViewAdaptor.ViewHolder> {


    Context context;
    ArrayList<HomeHorizontalListModel> singleMovieInfo;
    MovieItemClickListener movieItemClickListener;
    boolean isClicked = false;

    public SearchHomeViewAdaptor(Context context, ArrayList<HomeHorizontalListModel> singleMovieInfo, MovieItemClickListener listener) {
        this.context = context;
        this.singleMovieInfo = singleMovieInfo;
        movieItemClickListener = listener;
        notifyDataSetChanged();
    }

    public SearchHomeViewAdaptor(){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeHorizontalListModel movieInfo = singleMovieInfo.get(position);

        holder.rating.setText(movieInfo.getRating());
        holder.year.setText(movieInfo.getRelease_year());
        Glide.with(context).load(movieInfo.getPoster_url()).fitCenter().into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return singleMovieInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster,addMovie;
        TextView rating,year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.movie_poster);
            rating = itemView.findViewById(R.id.movie_rating);
            year = itemView.findViewById(R.id.movie_year);
            addMovie = itemView.findViewById(R.id.add_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMovieClick(singleMovieInfo.get(getAdapterPosition()),poster);
                }
            });

            addMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isClicked) {
                        movieItemClickListener.AddMovieToList(addMovie, true);
                        isClicked = true;
                    }else{
                        movieItemClickListener.AddMovieToList(addMovie, false);
                        isClicked = false;
                    }
                }
            });
        }
    }
}
