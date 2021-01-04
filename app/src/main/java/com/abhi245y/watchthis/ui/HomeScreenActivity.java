package com.abhi245y.watchthis.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.abhi245y.watchthis.Extra.Constants;
import com.abhi245y.watchthis.Extra.EndlessRecyclerViewScrollListener;
import com.abhi245y.watchthis.Extra.MovieItemClickListener;
import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
import com.abhi245y.watchthis.Models.OMDbMovieDetailsModel;
import com.abhi245y.watchthis.Models.OMDbSearchModel;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;
import com.abhi245y.watchthis.Models.TMDbMovieSearchModel;
import com.abhi245y.watchthis.Models.TMDbPopularModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.RecyclerviewAdaptors.HomeHorizontalViewAdaptor;
import com.abhi245y.watchthis.RecyclerviewAdaptors.SearchHomeViewAdaptor;
import com.abhi245y.watchthis.Retrofit.RetrofitBuild;
import com.abhi245y.watchthis.Services.OMDbService;
import com.abhi245y.watchthis.Services.TMDbService;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenActivity extends AppCompatActivity implements MovieItemClickListener {


    RecyclerView recyclerView, searchRecyclerView;
    HomeHorizontalViewAdaptor homeHorizontalViewAdaptor;
    ArrayList<HomeHorizontalListModel> singleMovieInfo  = new ArrayList<>();
    SearchHomeViewAdaptor searchHomeViewAdaptor;
    ArrayList<HomeHorizontalListModel> searchResultInfo  = new ArrayList<>();
    EndlessRecyclerViewScrollListener scrollListener;
    FloatingActionButton searchButton;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    ShimmerRecyclerView shimmerRecycler;
    SwipeRefreshLayout pullToRefresh;
    ImageView searchGradBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.movies);
        searchRecyclerView = findViewById(R.id.search_view);
        searchButton = findViewById(R.id.search_button);
        textInputLayout = findViewById(R.id.textInputLayout);
        textInputEditText = findViewById(R.id.textInputEdit);
        pullToRefresh = findViewById(R.id.pullToRefresh);
        searchGradBg = findViewById(R.id.search_grad_ng);

        textInputEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Toast.makeText(HomeScreenActivity.this, "Invoked: "+i, Toast.LENGTH_SHORT).show();
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    return true;
                }else if (i == 66){

                }
                return false;
            }
        });


        textInputEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        shimmerRecycler = findViewById(R.id.shimmer_recycler_view);
        shimmerRecycler.showShimmerAdapter();


        textInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == EditorInfo.IME_ACTION_SEARCH;
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        homeHorizontalViewAdaptor  = new HomeHorizontalViewAdaptor(this,singleMovieInfo, this);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        searchRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        searchHomeViewAdaptor = new SearchHomeViewAdaptor(this, searchResultInfo, this) ;
        searchRecyclerView.setAdapter(searchHomeViewAdaptor);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d("MainActivity","Page in Load More: "+page);
                generateList(1+page);
            }
        };

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textInputLayout.getVisibility() == View.GONE) {
                ArrayList<HomeHorizontalListModel> emptyList  = new ArrayList<>();
//                Toast.makeText(HomeScreenActivity.this, "First", Toast.LENGTH_SHORT).show();
                textInputLayout.setVisibility(View.VISIBLE);
                searchGradBg.setVisibility(View.VISIBLE);
                searchResultInfo.clear();
                searchResultInfo.addAll(emptyList);
                searchHomeViewAdaptor.notifyDataSetChanged();
                }else {
                    if (textInputEditText.getText()!=null) {
                        String query = textInputEditText.getText().toString();
                        if (query!=null) {
                            Toast.makeText(HomeScreenActivity.this, "Searching For: " + query, Toast.LENGTH_SHORT).show();
                            recyclerView.setVisibility(View.GONE);
//                            searchRecyclerView.setVisibility(View.VISIBLE);
                            shimmerRecycler.showShimmerAdapter();
                            searchMovie(1, textInputEditText.getText().toString());
                            searchRecyclerView.setVisibility(View.VISIBLE);
                            textInputLayout.setVisibility(View.GONE);
                            searchGradBg.setVisibility(View.GONE);
                        }
                    }
                }
            }
        });

        recyclerView.addOnScrollListener(scrollListener);
        recyclerView.setAdapter(homeHorizontalViewAdaptor);



        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefresh.setRefreshing(true);
                shimmerRecycler.showShimmerAdapter();
                ArrayList<HomeHorizontalListModel> emptyList = new ArrayList<>();
                if(recyclerView.getVisibility() == (View.VISIBLE)) {
                    singleMovieInfo.clear();
                    singleMovieInfo.addAll(emptyList);
                    homeHorizontalViewAdaptor.notifyDataSetChanged();
                    generateList(1);
                }else{
                    pullToRefresh.setRefreshing(false);
                }
            }
        });
    }

    private void searchMovie(int page, String movie_name){
        OMDbService omdbService = RetrofitBuild.getRetrofitOMDb().create(OMDbService.class);


        Call<OMDbSearchModel> apiResponse = omdbService.getMovieList(movie_name,page);

        apiResponse.enqueue(new Callback<OMDbSearchModel>() {
            @Override
            public void onResponse(Call<OMDbSearchModel> call, Response<OMDbSearchModel> response) {
                try {
                    if (response.isSuccessful()) {
                        for (OMDbSearchModel.SearchBean search : response.body().getSearch()) {

                            Call<OMDbMovieDetailsModel> movieDetailsModelCall = omdbService.getMovieDetails(search.getImdbID());

                            movieDetailsModelCall.enqueue(new Callback<OMDbMovieDetailsModel>() {
                                @Override
                                public void onResponse(Call<OMDbMovieDetailsModel> call, Response<OMDbMovieDetailsModel> response) {
                                    if (response.isSuccessful()) {
                                        OMDbMovieDetailsModel res = response.body();


                                        HomeHorizontalListModel listModel = new HomeHorizontalListModel(res.getTitle(), res.getPoster(), res.getImdbRating(),
                                                res.getReleased(), res.getPlot(), res.getImdbID(), res.getGenre());

                                        searchResultInfo.add(listModel);
                                    }
                                    searchHomeViewAdaptor.notifyDataSetChanged();
                                }

                                @Override
                                public void onFailure(Call<OMDbMovieDetailsModel> call, Throwable t) {

                                }
                            });
                        }
                        shimmerRecycler.hideShimmerAdapter();


                    } else {
                        searchTmdb(page, movie_name);
                        Log.d("Main", "No response Error: " + response);
                    }
                }catch(Exception e){
                    searchTmdb(page, movie_name);
                }
            }

            @Override
            public void onFailure(Call<OMDbSearchModel> call, Throwable t) {

            }
        });


    }

    public void searchTmdb(int page, String movie_name){
        TMDbService tmDbService = RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbMovieSearchModel> tmDbMovieSearchModelCall = tmDbService.searchTMDb(Constants.getTMDb_API_KEY(),movie_name,page);

        tmDbMovieSearchModelCall.enqueue(new Callback<TMDbMovieSearchModel>() {
            @Override
            public void onResponse(Call<TMDbMovieSearchModel> call, Response<TMDbMovieSearchModel> response) {
                if (response.isSuccessful()) {
                    for (TMDbMovieSearchModel.ResultsBean res:response.body().getResults()) {
                        String poster_url = "https://image.tmdb.org/t/p/w500" + res.getPoster_path();
                        HomeHorizontalListModel listModel = new HomeHorizontalListModel(res.getTitle(), poster_url,
                                String.valueOf(res.getVote_average()), res.getRelease_date(), res.getOverview(), res.getBackdrop_path(), res.getGenre_ids(), res.getId());
                        searchResultInfo.add(listModel);
                    }
                    searchHomeViewAdaptor.notifyDataSetChanged();
                    shimmerRecycler.hideShimmerAdapter();
                }else{
                    Log.d("Main", "No response Error: " + response);
                }
            }

            @Override
            public void onFailure(Call<TMDbMovieSearchModel> call, Throwable t) {

            }
        });
    }
    private void generateList(int page) {
        TMDbService tmDbService = RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbPopularModel> tmDbPopularModelCall = tmDbService.getTMDbPopular("popular",Constants.getTMDb_API_KEY(),"en-US",page,"IN");

        tmDbPopularModelCall.enqueue(new Callback<TMDbPopularModel>() {
            @Override
            public void onResponse(Call<TMDbPopularModel> call, Response<TMDbPopularModel> response) {

                List<TMDbPopularModel.ResultsBean> resultsBeans= response.body().getResults();
                for(TMDbPopularModel.ResultsBean res:resultsBeans){
                    String poster_url = "https://image.tmdb.org/t/p/w500" + res.getPoster_path();
                    ArrayList<Integer> genre_code = new ArrayList<>(res.getGenre_ids());
                    int TMDb_ID = res.getId();

                    HomeHorizontalListModel listModel = new HomeHorizontalListModel(res.getTitle(), poster_url,
                            String.valueOf(res.getVote_average()), res.getRelease_date(), res.getOverview(), res.getBackdrop_path(), genre_code, TMDb_ID);
                    singleMovieInfo.add(listModel);
                    homeHorizontalViewAdaptor.notifyDataSetChanged();
                }
                shimmerRecycler.hideShimmerAdapter();
                pullToRefresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<TMDbPopularModel> call, Throwable t) {
                t.printStackTrace();
                generateList(page);
            }
        });

    }

    @Override
    public void onMovieClick(HomeHorizontalListModel movie_details, ImageView movieImage) {
        String TMDB_ID = Integer.toString(movie_details.getTMDb_Id());
        String IMDB_ID =  movie_details.getImdbId();
        Log.d("HomeScreenActivity","TMDb ID: "+TMDB_ID+" IMDB ID: "+IMDB_ID);
        Intent intent = new Intent(this, MovieCardActivity.class);
        intent.putExtra("movie_name",movie_details.getTitle_name());
        intent.putExtra("poster_url", movie_details.getPoster_url());
        intent.putExtra("backdrop",movie_details.getBackdrop_url());
        intent.putExtra("release_year",movie_details.getRelease_year() );
        intent.putExtra("rating",movie_details.getRating());
        intent.putExtra("IMDB_ID",IMDB_ID);
        intent.putExtra("TMDB_ID",TMDB_ID);
        if (IMDB_ID == null) {
            intent.putIntegerArrayListExtra("genres", movie_details.getGenres());
        }else{
            intent.putExtra("genres",movie_details.getGenresOMDb());
        }
        intent.putExtra("overview",movie_details.getOverview());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeScreenActivity.this,movieImage,"movieCardAnimation");
        this.startActivity(intent,options.toBundle());
    }

    @Override
    public void onSimilarMovieClick(SimilarMoviesListModel movie_details, ImageView movieImage) {

    }

    @Override
    public void AddMovieToList(ImageView favIcon, boolean isClicked) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        generateList(1);
    }

    @Override
    public void onBackPressed() {
        if (searchRecyclerView.getVisibility() == View.VISIBLE){
            searchRecyclerView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            textInputLayout.setVisibility(View.GONE);
        }else{
            super.onBackPressed();
        }
    }
}