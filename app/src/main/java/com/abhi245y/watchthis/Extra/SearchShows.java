package com.abhi245y.watchthis.Extra;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.abhi245y.watchthis.Models.JustWacthSearchModel;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;
import com.abhi245y.watchthis.Models.TMDbGetImagesModel;
import com.abhi245y.watchthis.Models.TMDbIDModel;
import com.abhi245y.watchthis.Models.TMDbSimilarMoviesModel;
import com.abhi245y.watchthis.Models.TelegramResultsModel;
import com.abhi245y.watchthis.Models.TelegramSearchModel;
import com.abhi245y.watchthis.Models.WatchOptionsModel;
import com.abhi245y.watchthis.Models.YTSModelPopularList;
import com.abhi245y.watchthis.RecyclerviewAdaptors.SimilarMoviesViewAdaptor;
import com.abhi245y.watchthis.RecyclerviewAdaptors.WatchOptionsAdaptor;
import com.abhi245y.watchthis.Retrofit.RetrofitBuild;
import com.abhi245y.watchthis.Services.JustWatchService;
import com.abhi245y.watchthis.Services.TMDbService;
import com.abhi245y.watchthis.Services.TelegramService;
import com.abhi245y.watchthis.Services.YTSService;
import com.bumptech.glide.Glide;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchShows {

    public static String show_name;

    public static JustWacthSearchModel.ItemsBean itemsBean;

    public static JustWacthSearchModel.ItemsBean getItemsBean() {
        return itemsBean;
    }
    public void setItemsBean(JustWacthSearchModel.ItemsBean itemsBean) {
        SearchShows.itemsBean = itemsBean;
    }


    private static void SearchYTS(String imDbId) {
        YTSService ytsService= RetrofitBuild.getRetrofitYTS().create(YTSService.class);
        Call<YTSModelPopularList> apiResponseCall=ytsService.SearchYTS(imDbId);

        apiResponseCall.enqueue(new Callback<YTSModelPopularList>() {
            @Override
            public void onResponse(Call<YTSModelPopularList> call, Response<YTSModelPopularList> response) {
                for (YTSModelPopularList.DataBean.MoviesBean results:response.body().getData().getMovies()){
                    int YTSId = results.getId();
                    Log.d("SearchShows","YTSId: "+YTSId);
                }
            }
            @Override
            public void onFailure(Call<YTSModelPopularList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void GetImagesLink(String IMDbId, ImageView backdrop, Context applicationContext){
        TMDbService tmDbService =RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbGetImagesModel> tmDbMovieSearchByIDModelCall = tmDbService.getImages(IMDbId,Constants.getTMDb_API_KEY());

        Log.d("SearchShows","IMDbId: "+IMDbId+" Getting Image");

        tmDbMovieSearchByIDModelCall.enqueue(new Callback<TMDbGetImagesModel>() {
            @Override
            public void onResponse(Call<TMDbGetImagesModel> call, Response<TMDbGetImagesModel> response) {
                if (response.isSuccessful()) {
                    TMDbGetImagesModel res = response.body();
//                    for (TMDbGetImagesModel.BackdropsBean backdropsBean : res.getBackdrops()) {
                        String fileLink = "https://image.tmdb.org/t/p/original"+res.getBackdrops().get(0).getFile_path();
                        Glide.with(applicationContext)
                                .load(fileLink)
                                .fitCenter()
                                .into(backdrop);

                        Log.d("SearchShows","Getting Image >> Image Link: "+fileLink);
//                    }
                    
                }else {
                    Log.d("SearchShows","No response");
                }
            }

            @Override
            public void onFailure(Call<TMDbGetImagesModel> call, Throwable t) {
                t.printStackTrace();
                Log.d("SearchShows","Getting Image No response: "+t);
            }
        });
    }

    public static void GetWatchOptions(String IMDbId, int page, String show_name, ArrayList<WatchOptionsModel> watchOptionsModels,
                                       WatchOptionsAdaptor watchadaptor, ShimmerRecyclerView shimmerRecycler){
        TMDbService tmDbService =RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbIDModel> tmDbIDModelCall = tmDbService.getTMDbID(IMDbId,Constants.getTMDb_API_KEY());

        tmDbIDModelCall.enqueue(new Callback<TMDbIDModel>() {
            @Override
            public void onResponse(Call<TMDbIDModel> call, Response<TMDbIDModel> response) {
                if (response.isSuccessful()) {
                    TMDbIDModel res = response.body();
                    int TMDbID = res.getId();

                    GetJustWatch(TMDbID, page, watchOptionsModels, watchadaptor, shimmerRecycler);

                }else {
                    Log.d("SearchShows","No response");
                }

            }

            @Override
            public void onFailure(Call<TMDbIDModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void GetJustWatch(int TMDbID, int page, ArrayList<WatchOptionsModel> watchOptionsModels, WatchOptionsAdaptor watchadaptor, ShimmerRecyclerView shimmerRecycler){
        JustWatchService justWatchService = RetrofitBuild.getRetrofitJustWacth().create(JustWatchService.class);
        Call<JustWacthSearchModel> apiResponseCall=justWatchService
                .getJustWatchPopular("{\"page_size\":25,\"page\":"+page+",\"query\":\""+show_name+"\",\"content_types\":[\"movie\"]}");

        apiResponseCall.enqueue(new Callback<JustWacthSearchModel>() {
            @Override
            public void onResponse(Call<JustWacthSearchModel> call, Response<JustWacthSearchModel> response) {
                if (response.isSuccessful()) {
                    try {
                        for (JustWacthSearchModel.ItemsBean result : response.body().getItems()) {
                            for (JustWacthSearchModel.ItemsBean.ScoringBean rating : result.getScoring()) {
                                if (rating.getProvider_type().equals("tmdb:id")) {
                                    if (rating.getValue() == TMDbID) {
                                        Log.d("SearchShows","JustWatch Item Found: "+result.getTitle());
                                        for (JustWacthSearchModel.ItemsBean.OffersBean offersBean: result.getOffers()){
                                            if (offersBean.getMonetization_type().equals("flatrate")){
                                                JustWacthSearchModel.ItemsBean.OffersBean.UrlsBean urlsBean = offersBean.getUrls();
                                                String standardWeb = urlsBean.getStandard_web();
                                                Log.d("SearchShows","standardWeb: "+standardWeb);
                                                WatchOptionsModel singleWatchOptionsModel = new WatchOptionsModel("justWatch",standardWeb,offersBean.getMonetization_type(),offersBean.getProvider_id());
                                                watchOptionsModels.add(singleWatchOptionsModel);
                                                break;
                                            }
                                        }

                                        shimmerRecycler.setDemoChildCount(3-watchOptionsModels.size());
                                        watchadaptor.notifyDataSetChanged();
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

//                    Document doc = Jsoup.connect().get();
                }else{
                    Log.d("SearchShows","No response");
                }
            }

            @Override
            public void onFailure(Call<JustWacthSearchModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void searchTelegram(String show_name, ArrayList<WatchOptionsModel> watchOptionsModels, WatchOptionsAdaptor watchadaptor, ShimmerRecyclerView shimmerRecycler){
        TelegramService telegramService = RetrofitBuild.getRetrofitTG().create(TelegramService.class);
        String movie_name = show_name.replaceAll(":","").replace(".","");
        Log.d("SearchShows","Show Name: "+movie_name);
        Call<ArrayList<TelegramSearchModel>> telegramServiceCall = telegramService.searchTelegram(movie_name);

        telegramServiceCall.enqueue(new Callback<ArrayList<TelegramSearchModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TelegramSearchModel>> call, Response<ArrayList<TelegramSearchModel>> response) {
                if (response.isSuccessful()) {
                    Log.d("SearchShows","TG Success");
                    ArrayList<TelegramSearchModel> telegramSearchModel = response.body();
                    if (telegramSearchModel != null) {
                        ArrayList<TelegramResultsModel> telegramResultsModels = new ArrayList<>();
                        for (TelegramSearchModel result:telegramSearchModel){
                            Log.d("SearchShows","TG results file name: "+result.getFile_name());
                            String tg_link = result.getPerma_link();
                            String file_name = result.getFile_name();
                            String caption = result.getCaption();
                            int size = result.getFile_size();
                            TelegramResultsModel telegramResultsModel = new TelegramResultsModel(file_name,caption,size,tg_link);
                            telegramResultsModels.add(telegramResultsModel);
                        }
                        WatchOptionsModel singleWatchOptionsModel = new WatchOptionsModel(telegramResultsModels,"telegram");
                        watchOptionsModels.add(singleWatchOptionsModel);
                        shimmerRecycler.hideShimmerAdapter();
                        watchadaptor.notifyDataSetChanged();
                    }else {
                        Log.d("SearchShows","TelegramSearchModel Array Null");
                    }

                }else {
                    Log.d("SearchShows","TG No Response");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TelegramSearchModel>> call, Throwable t) {
                Log.d("SearchShows","TG Failed");
//                ArrayList<TelegramResultsModel> telegramResultsModels = new ArrayList<>();
//                TelegramResultsModel telegramResultsModel = new TelegramResultsModel("@cc captain marvel 2019 720p bdrip tam tel hin eng esubs mkv","Captain Marvel (2019) [720p - BDRip - Original Audios [Tamil  Telugu  Hindi  Eng] - x264 - 1.1GB - ESubs]\\n\\n@CC_TamilDubbed | @CC_Links","1211507993","https://t.me/pmudbdeivomargeletmoviedbdumppmu/167530");
//                telegramResultsModels.add(telegramResultsModel);
//                WatchOptionsModel singleWatchOptionsModel = new WatchOptionsModel(telegramResultsModels,"telegram");
//                watchOptionsModels.add(singleWatchOptionsModel);
//                watchadaptor.notifyDataSetChanged();
                t.printStackTrace();
            }
        });
    }

    public static void GetSimilarMoviesAlt(String IMDbId, ArrayList<SimilarMoviesListModel> similarMoviesListModels,
                                           SimilarMoviesViewAdaptor similarMoviesViewAdaptor, ShimmerRecyclerView similarMoviesShimmerRecyclerView){
        TMDbService tmDbService =RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbIDModel> tmDbIDModelCall = tmDbService.getTMDbID(IMDbId,Constants.getTMDb_API_KEY());

        tmDbIDModelCall.enqueue(new Callback<TMDbIDModel>() {
            @Override
            public void onResponse(Call<TMDbIDModel> call, Response<TMDbIDModel> response) {
                if (response.isSuccessful()) {
                    TMDbIDModel res = response.body();
                    String movie_id = res.getId().toString();

                    GetSimilarMovies(movie_id, similarMoviesListModels, similarMoviesViewAdaptor, similarMoviesShimmerRecyclerView);

                }else {
                    Log.d("SearchShows","No response");
                }

            }

            @Override
            public void onFailure(Call<TMDbIDModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void GetSimilarMovies(String movieId, ArrayList<SimilarMoviesListModel> similarMoviesListModels,
                                        SimilarMoviesViewAdaptor similarMoviesViewAdaptor, ShimmerRecyclerView similarMoviesShimmerRecyclerView){
        TMDbService tmDbService = RetrofitBuild.getRetrofitTMDb().create(TMDbService.class);
        Call<TMDbSimilarMoviesModel> tmDbSimilarMoviesModelCall = tmDbService.getSimilarMovies(movieId,Constants.getTMDb_API_KEY());
        Log.d("SearchShows","Getting Similar Movies Movie ID: "+movieId);
        tmDbSimilarMoviesModelCall.enqueue(new Callback<TMDbSimilarMoviesModel>() {
            @Override
            public void onResponse(Call<TMDbSimilarMoviesModel> call, Response<TMDbSimilarMoviesModel> response) {
                if (response.isSuccessful()){
                    TMDbSimilarMoviesModel tmDbSimilarMoviesModel = response.body();
                    if (tmDbSimilarMoviesModel != null) {
                        Log.d("SearchShows","TMDbSimilarMoviesModel Array Not Null");
                        for (TMDbSimilarMoviesModel.ResultsBean res:tmDbSimilarMoviesModel.getResults()){

                            String thumbnail_url = "https://image.tmdb.org/t/p/w500"+ res.getBackdrop_path();
                            String rating = res.getVote_average().toString().replace(".","");
                            SimilarMoviesListModel similarMoviesModel = new SimilarMoviesListModel(res.getTitle(), rating, thumbnail_url, res);
                            similarMoviesListModels.add(similarMoviesModel);
                            Log.d("SearchShows","Similar Movies: "+res.getTitle());
                        }
                        similarMoviesShimmerRecyclerView.hideShimmerAdapter();
                        similarMoviesViewAdaptor.notifyDataSetChanged();

                    }else{
                        Log.d("SearchShows","TMDbSimilarMoviesModel Array Null");
                    }
                }else{
                    Log.d("SearchShows","Similar Movies No Response: "+response);
                }
            }

            @Override
            public void onFailure(Call<TMDbSimilarMoviesModel> call, Throwable t) {
                Log.d("SearchShows","Similar Movies Failed: "+t);
            }
        });
    }


}