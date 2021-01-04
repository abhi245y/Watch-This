 package com.abhi245y.watchthis.ui;

 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.abhi245y.watchthis.Extra.Constants;
 import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
 import com.abhi245y.watchthis.Models.HomeVerticalListModel;
 import com.abhi245y.watchthis.Models.JustWacthSearchModel;
 import com.abhi245y.watchthis.Models.TMDbPopularModel;
 import com.abhi245y.watchthis.R;
 import com.abhi245y.watchthis.RecyclerviewAdaptors.HomeHorizontalViewAdaptor;
 import com.abhi245y.watchthis.RecyclerviewAdaptors.HomeRecyclerviewAdaptor;
 import com.abhi245y.watchthis.Retrofit.RetrofitBuild;
 import com.abhi245y.watchthis.Services.JustWatchService;
 import com.abhi245y.watchthis.Services.TMDbService;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Map;

 import retrofit2.Call;
 import retrofit2.Callback;
 import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView homeVerticalList;
    HomeRecyclerviewAdaptor homeVerticalRecyclerviewAdaptor;
    ArrayList<HomeVerticalListModel> homeVerticalListModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText query = findViewById(R.id.qurey_index);
        Button searchButton  = findViewById(R.id.search_button);
        Log.d(TAG,"Started");

        homeVerticalListModel = new ArrayList<>();

        homeVerticalList = findViewById(R.id.homeVerticalRecyclerView);
        homeVerticalList.setHasFixedSize(true);

        homeVerticalList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        homeVerticalRecyclerviewAdaptor  = new HomeRecyclerviewAdaptor(this,homeVerticalListModel,MainActivity.this);
        homeVerticalList.setAdapter(homeVerticalRecyclerviewAdaptor);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeVerticalListModel.clear();
            }
        });

        getMovies("a");

    }
     private void getMovies(String query) {
         HomeHorizontalViewAdaptor homeHorizontalViewAdaptor = new HomeHorizontalViewAdaptor();
         ArrayList<HomeHorizontalListModel> homeHorizontalListModels = new ArrayList<>();

         for(Map.Entry service_code : Constants.getServices().entrySet()) {
             HomeVerticalListModel verticalListModel = new HomeVerticalListModel();
             verticalListModel.setService_code(Integer.parseInt(service_code.getKey().toString()));
             verticalListModel.setQurey_name(query);
             if (service_code.getValue().equals("YTS Torrent")){
//                 getYTS(verticalListModel, 1,homeHorizontalViewAdaptor,homeHorizontalListModels,23);
             }
             if (service_code.getValue().equals("Just Watch")){
                 getJustWatch(verticalListModel, 1,homeHorizontalViewAdaptor,homeHorizontalListModels,23);
             }
             if (service_code.getValue().equals("The Movie Database")){
                 TMDbService tmDbService = RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
                 getTMDb(tmDbService,verticalListModel, 1,homeHorizontalViewAdaptor,homeHorizontalListModels,23);
             }
         }
     }

//     public void getYTS(HomeVerticalListModel verticalListModel, int page, HomeHorizontalViewAdaptor homeHorizontalViewAdaptor,
//                        ArrayList<HomeHorizontalListModel> homeHorizontalListModels, int RequestCode){
//         YTSService ytsService= RetrofitBuild.getRetrofitYTS().create(YTSService.class);
//         Call<YTSModelPopularList> apiResponseCall=ytsService.getYTSPopularList(String.valueOf(page));
//         apiResponseCall.enqueue(new Callback<YTSModelPopularList>() {
//             @Override
//             public void onResponse(Call<YTSModelPopularList> call, Response<YTSModelPopularList> response) {
//                 List<YTSModelPopularList.DataBean.MoviesBean> moviesBeans = response.body().getData().getMovies();
//                 ArrayList<HomeHorizontalListModel> horizontalListModels = new ArrayList<>();
//                 for (YTSModelPopularList.DataBean.MoviesBean results:moviesBeans) {
////                     Log.d(TAG,"InsideLoop: "+results.getTitle());
//                     ArrayList<String> geners = new ArrayList<>(results.getGenres());
//                     String overview = results.getDescription_full();
//                     HomeHorizontalListModel listModel = new HomeHorizontalListModel(results.getTitle_english(),
//                             results.getMedium_cover_image(), String.valueOf(results.getRating()), String.valueOf(results.getYear()),geners,overview);
//                     horizontalListModels.add(listModel);
//                 }
//                 if (RequestCode == 23) {
//                     verticalListModel.setHorizontalListModel(horizontalListModels);
//                     homeVerticalListModel.add(verticalListModel);
//                     MainActivity.this.homeVerticalRecyclerviewAdaptor.notifyDataSetChanged();
//                     Log.d(TAG, "Loop Exited");
//                 }else refreshRecyclerview(homeHorizontalViewAdaptor,horizontalListModels,homeHorizontalListModels);
//             }
//
//             @Override
//             public void onFailure(Call<YTSModelPopularList> call, Throwable t) {
//                 Log.d(TAG,"Unable to get YTS List Error: ",t);
//             }
//         });
//     }


     public void getJustWatch(HomeVerticalListModel verticalListModel, int page, HomeHorizontalViewAdaptor homeHorizontalViewAdaptor,
                              ArrayList<HomeHorizontalListModel> homeHorizontalListModels, int RequestCode){
         JustWatchService justWatchService = RetrofitBuild.getRetrofitJustWacth().create(JustWatchService.class);
         Log.d(TAG,"Page: "+page);
         String movie_name = verticalListModel.getQurey_name();
         Call<JustWacthSearchModel> apiResponseCall=justWatchService.getJustWatchPopular("{\"page_size\":5,\"page\":"+page+",\"query\":\""+movie_name+"\",\"content_types\":[\"movie\"]}");

         apiResponseCall.enqueue(new Callback<JustWacthSearchModel>() {
             @Override
             public void onResponse(Call<JustWacthSearchModel> call, Response<JustWacthSearchModel> response) {
                 List<JustWacthSearchModel.ItemsBean> itemsBeans = response.body().getItems();
                 ArrayList<HomeHorizontalListModel> horizontalListModels = new ArrayList<>();
                 for (JustWacthSearchModel.ItemsBean result:itemsBeans){
                     String poster_url = "https://images.justwatch.com"+result.getPoster().replace("{profile}","s332");
//                     Log.d(TAG,"Poster URL: "+poster_url);
                     List<JustWacthSearchModel.ItemsBean.ScoringBean> scoringBeans = result.getScoring();
                     for (JustWacthSearchModel.ItemsBean.ScoringBean rating:scoringBeans) {
                         if (rating.getProvider_type().equals("imdb:score")) {
                             HomeHorizontalListModel listModel = new HomeHorizontalListModel(result.getTitle(), poster_url, String.valueOf(rating.getValue()),
                                     String.valueOf(result.getOriginal_release_year()));
                             horizontalListModels.add(listModel);
                         }
                     }
                 }
                 if (RequestCode == 23) {
                     verticalListModel.setHorizontalListModel(horizontalListModels);
                     homeVerticalListModel.add(verticalListModel);
                     MainActivity.this.homeVerticalRecyclerviewAdaptor.notifyDataSetChanged();
                     Log.d(TAG, "Loop Exited");
                 }else refreshRecyclerview(homeHorizontalViewAdaptor,horizontalListModels,homeHorizontalListModels);
             }

             @Override
             public void onFailure(Call<JustWacthSearchModel> call, Throwable t) {
                 Log.d(TAG,"Unable to get JustWatch List Error: ",t);
             }
         });
     }

     public void getTMDb(TMDbService tmDbService, HomeVerticalListModel verticalListModel, int page, HomeHorizontalViewAdaptor homeHorizontalViewAdaptor,
                         ArrayList<HomeHorizontalListModel> homeHorizontalListModels, int RequestCode){

         Call<TMDbPopularModel> apiResponseCall=tmDbService.getTMDbPopular("popular","7d8ad71f7e277923665d1197cb77e46b","ml",page,"IN");

         //         Call<TMDbMovieSearchModel> apiResponseCall=tmDbService.searchTMDb("7d8ad71f7e277923665d1197cb77e46b",verticalListModel.getQurey_name(),page);

//         apiResponseCall.enqueue(new Callback<TMDbMovieSearchModel>() {
////             @Override
////             public void onResponse(Call<TMDbMovieSearchModel> call, Response<TMDbMovieSearchModel> response) {
////                 List<TMDbMovieSearchModel.ResultsBean> resultsBeans= response.body().getResults();
////                 ArrayList<HomeHorizontalListModel> horizontalListModels = new ArrayList<>();
////                 for (TMDbMovieSearchModel.ResultsBean res:resultsBeans){
////                     String poster_url ="https://image.tmdb.org/t/p/w500"+res.getPoster_path();
////                     HomeHorizontalListModel listModel = new HomeHorizontalListModel(res.getOriginal_title(),poster_url,
////                             String.valueOf(res.getVote_average()),res.getRelease_date());
////                     horizontalListModels.add(listModel);
////                 }
////                 if (RequestCode == 23) {
////                     verticalListModel.setHorizontalListModel(horizontalListModels);
////                     homeVerticalListModel.add(verticalListModel);
////                     MainActivity.this.homeVerticalRecyclerviewAdaptor.notifyDataSetChanged();
////                     Log.d(TAG, "Loop Exited");
////                 } else {
////                     refreshRecyclerview(homeHorizontalViewAdaptor, horizontalListModels, homeHorizontalListModels);
////                 }
////             }
////             @Override
////             public void onFailure(Call<TMDbMovieSearchModel> call, Throwable t) {
////                 Log.d(TAG,"Unable to get TMDb List Error: ",t);
////             }
////         });

         apiResponseCall.enqueue(new Callback<TMDbPopularModel>() {
             @Override
             public void onResponse(Call<TMDbPopularModel> call, Response<TMDbPopularModel> response) {
                 List<TMDbPopularModel.ResultsBean> resultsBeans= response.body().getResults();
                 ArrayList<HomeHorizontalListModel> horizontalListModels = new ArrayList<>();
                 for (TMDbPopularModel.ResultsBean res:resultsBeans){
                    Log.d(TAG,"Original Language: "+res.getOriginal_language());
                     if (res.getOriginal_language().equals("ml")) {
                         String poster_url = "https://image.tmdb.org/t/p/w500" + res.getPoster_path();
                         HomeHorizontalListModel listModel = new HomeHorizontalListModel(res.getOriginal_title(), poster_url,
                                 String.valueOf(res.getVote_average()), res.getRelease_date());
                         horizontalListModels.add(listModel);
                     }else if (page<=response.body().getTotal_pages()){
                         Toast.makeText(MainActivity.this, "Next Search", Toast.LENGTH_SHORT).show();
                         getTMDb(tmDbService, verticalListModel, page+1,homeHorizontalViewAdaptor,homeHorizontalListModels,23);
                     }else {
                         Toast.makeText(MainActivity.this, "Not Result", Toast.LENGTH_SHORT).show();
                     }
                 }
                 if (RequestCode == 23) {
                     verticalListModel.setHorizontalListModel(horizontalListModels);
                     homeVerticalListModel.add(verticalListModel);
                     MainActivity.this.homeVerticalRecyclerviewAdaptor.notifyDataSetChanged();
                     Log.d(TAG, "Loop Exited");
                 } else {
                     refreshRecyclerview(homeHorizontalViewAdaptor, horizontalListModels, homeHorizontalListModels);
                 }
             }
             @Override
             public void onFailure(Call<TMDbPopularModel> call, Throwable t) {
                 Log.d(TAG,"Unable to get TMDb List Error: ",t);
             }
         });
     }

     private void refreshRecyclerview(HomeHorizontalViewAdaptor homeHorizontalViewAdaptor,ArrayList<HomeHorizontalListModel> horizontalListModels,
                                      ArrayList<HomeHorizontalListModel> homeHorizontalListModels) {
             homeHorizontalListModels.addAll(horizontalListModels);
             homeHorizontalViewAdaptor.notifyDataSetChanged();
     }

 }