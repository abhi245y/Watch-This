package com.abhi245y.watchthis.Services;

import com.abhi245y.watchthis.Models.YTSModelPopularList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YTSService {
    @GET("list_movies.json")
    Call<YTSModelPopularList> getYTSPopularList(@Query("page") String page_num);

    @GET("list_movies.json")
    Call<YTSModelPopularList> SearchYTS(@Query("query_term") String query_term);
}
