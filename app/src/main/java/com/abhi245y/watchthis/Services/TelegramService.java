package com.abhi245y.watchthis.Services;

import com.abhi245y.watchthis.Models.TelegramSearchModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TelegramService {

    @GET("{movie_name}")
    Call<ArrayList<TelegramSearchModel>> searchTelegram(@Path("movie_name") String movie_name);
}
