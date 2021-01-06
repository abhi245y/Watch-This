package com.abhi245y.watchthis.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Extra.Constants;
import com.abhi245y.watchthis.Extra.MovieItemClickListener;
import com.abhi245y.watchthis.Extra.SearchShows;
import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;
import com.abhi245y.watchthis.Models.TMDbSimilarMoviesModel;
import com.abhi245y.watchthis.Models.WatchOptionsModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.RecyclerviewAdaptors.SimilarMoviesViewAdaptor;
import com.abhi245y.watchthis.RecyclerviewAdaptors.WatchOptionsAdaptor;
import com.bumptech.glide.Glide;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MovieCardActivity extends AppCompatActivity implements MovieItemClickListener {

    private static final String TAG = "MovieCardActivity";
    String poster_url,movie_name,synopsis, ImdbID, none;
    String release_year,voting, movie_id;
    TextView name,rating,year,gener,overview;
    ImageView movie_Image,backdrop;
    RatingBar ratingBar;
    WatchOptionsAdaptor watchOptionsAdaptor;
    ArrayList<WatchOptionsModel> watchOptionsModels;
    ArrayList<SimilarMoviesListModel> similarMoviesListModels;
    SimilarMoviesViewAdaptor similarMoviesViewAdaptor;
    RecyclerView watchOptionView,similarMoviesView;
    java.util.HashMap<Integer,String> generCode=new HashMap<>();
    TMDbSimilarMoviesModel.ResultsBean tmDbSimilarMovieResultModel;
    ShimmerRecyclerView watchOptionsShimmerRecyclerView, similarMoviesShimmerRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_card_model);

        name = findViewById(R.id.title_name);
        year = findViewById(R.id.title_relase);
        rating = findViewById(R.id.rating);
        gener = findViewById(R.id.title_gener);
        ratingBar = findViewById(R.id.ratingBar);
        movie_Image = findViewById(R.id.poster_image);
        generCode = Constants.getGenerCode();
        overview = findViewById(R.id.movie_overview);
        backdrop = findViewById(R.id.backdrop);
        watchOptionView = findViewById(R.id.WatchNowOptions);
        similarMoviesView = findViewById(R.id.similarMoviesView);
        backdrop.setBackgroundResource(R.drawable.backdrop_tump_3);

        watchOptionsModels =new ArrayList<>();
        watchOptionView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        watchOptionsAdaptor = new WatchOptionsAdaptor(watchOptionsModels,this);
        watchOptionView.setAdapter(watchOptionsAdaptor);

        similarMoviesListModels =new ArrayList<>();
        similarMoviesView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        similarMoviesViewAdaptor = new SimilarMoviesViewAdaptor(this, similarMoviesListModels, tmDbSimilarMovieResultModel ,this);
        similarMoviesView.setAdapter(similarMoviesViewAdaptor);

        watchOptionsShimmerRecyclerView = findViewById(R.id._watch_option_shimmer_recycler_view);
//        watchOptionsShimmerRecyclerView.setDemoChildCount(3);
        watchOptionsShimmerRecyclerView.showShimmerAdapter();

        similarMoviesShimmerRecyclerView = findViewById(R.id.similar_movie_shimmer_recycler_view);
        similarMoviesShimmerRecyclerView.showShimmerAdapter();

        getIncomingIntent();

    }

    @SuppressLint("SetTextI18n")
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        poster_url = getIntent().getStringExtra("poster_url");
        movie_name = getIntent().getStringExtra("movie_name");
        release_year = getIntent().getStringExtra("release_year");


        if (getIntent().getStringExtra("IMDB_ID") == null ){
            movie_id = getIntent().getStringExtra("TMDB_ID");
            Log.d(TAG,"Tmdb_ID: "+movie_id);
            Log.d(TAG,"Query: "+movie_name+" Year: "+release_year+" TMDb Id: "+movie_id);
            String backdrop_url = "https://image.tmdb.org/t/p/original"+getIntent().getStringExtra("backdrop");
            Log.d(TAG,"Imdb is null >> backdrop_url: "+backdrop_url);
            for (Integer genre_id : Objects.requireNonNull(getIntent().getIntegerArrayListExtra("genres"))) {
                for (Map.Entry genres_map : generCode.entrySet()) {
                    if (genre_id.equals(genres_map.getKey())) {
                        gener.setText(genres_map.getValue().toString());
                    }
                }
            }
            Glide.with(getApplicationContext())
                    .load(backdrop_url)
                    .fitCenter()
                    .into(backdrop);
           SearchShows.GetJustWatch(Integer.parseInt(movie_id),1,watchOptionsModels, watchOptionsAdaptor, watchOptionsShimmerRecyclerView, movie_name);
           SearchShows.searchTelegram(movie_name,watchOptionsModels, watchOptionsAdaptor, watchOptionsShimmerRecyclerView);
           SearchShows.GetSimilarMovies(movie_id, similarMoviesListModels, similarMoviesViewAdaptor, similarMoviesShimmerRecyclerView);
        }else{
            movie_id = getIntent().getStringExtra("IMDB_ID");
            ImdbID = movie_id;
            Log.d(TAG," Imdb_ID: "+movie_id);
            gener.setText(getIntent().getStringExtra("genres"));
            Log.d(TAG,"Query: "+movie_name+" Year: "+release_year+" ImdbId: "+movie_id);
            SearchShows.GetImagesLink(movie_id, backdrop, getApplicationContext());
            SearchShows.GetWatchOptions(movie_id,1,movie_name,watchOptionsModels, watchOptionsAdaptor, watchOptionsShimmerRecyclerView);
            SearchShows.searchTelegram(movie_name,watchOptionsModels, watchOptionsAdaptor, watchOptionsShimmerRecyclerView);
            SearchShows.GetSimilarMoviesAlt(movie_id, similarMoviesListModels, similarMoviesViewAdaptor, similarMoviesShimmerRecyclerView);
        }
//        Log.d(TAG,"Query: "+movie_name+" Year: "+release_year+" TMDb Id: "+getIntent().getStringExtra("Imdb_id"));
        String ImdbRating = getIntent().getStringExtra("rating");
        if (!ImdbRating.equals("N/A")) {
            float vote = Float.parseFloat(Objects.requireNonNull(getIntent().getStringExtra("rating")));
            rating.setText(String.valueOf(vote));
            ratingBar.setRating(vote/2);
        }else{
            rating.setText("No Rating");
        }

        backdrop.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

        Glide.with(getApplicationContext())
                .load(poster_url)
                .fitCenter()
                .into(movie_Image);

        name.setText(movie_name);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            LocalDate date = LocalDate.parse(release_year);
//        }
        year.setText(String.valueOf(release_year));
        voting = getIntent().getStringExtra("rating");
        synopsis = getIntent().getStringExtra("overview");
        overview.setText(synopsis);

        Toast.makeText(this, "Loading Watch Options Please wait a sec", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onMovieClick(HomeHorizontalListModel movie_details, ImageView movieImage) {

    }

    @Override
    public void onSimilarMovieClick(SimilarMoviesListModel movie_details, ImageView movieImage) {

        TMDbSimilarMoviesModel.ResultsBean res =  movie_details.getTmDbSimilarMovieResultModel();
        String poster_url = "https://image.tmdb.org/t/p/original"+res.getPoster_path();
        Intent intent = new Intent(this, MovieCardActivity.class);
        intent.putExtra("movie_name",res.getTitle());
        intent.putExtra("poster_url", poster_url);
        intent.putExtra("backdrop",res.getBackdrop_path());
        intent.putExtra("release_year",res.getRelease_date());
        intent.putExtra("rating",Double.toString(res.getVote_average()));
        intent.putExtra("IMDB_ID",ImdbID);
        intent.putExtra("TMDB_ID",Integer.toString(res.getId()));
        intent.putIntegerArrayListExtra("genres", res.getGenre_ids());
        intent.putExtra("overview",res.getOverview());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MovieCardActivity.this,movieImage,"movieCardAnimation");
        this.startActivity(intent,options.toBundle());
    }

    @Override
    public void AddMovieToList(ImageView favIcon, boolean isClicked) {

    }
}
