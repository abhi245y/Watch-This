package com.abhi245y.watchthis.Services;

import com.abhi245y.watchthis.Models.OMDbMovieDetailsModel;
import com.abhi245y.watchthis.Models.OMDbSearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OMDbService {

    @GET("/?apikey=9a7a1eb3")
    Call<OMDbSearchModel> getMovieList(@Query("s") String query, @Query("page") int page);

    @GET("/?apikey=9a7a1eb3")
    Call<OMDbMovieDetailsModel> getMovieDetails(@Query("i") String id);
}
