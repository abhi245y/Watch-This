package com.abhi245y.watchthis.Services;

import com.abhi245y.watchthis.Models.JustWacthSearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JustWatchService {
    @GET("popular")
    Call<JustWacthSearchModel> getJustWatchPopular(@Query("body") String body);
}
