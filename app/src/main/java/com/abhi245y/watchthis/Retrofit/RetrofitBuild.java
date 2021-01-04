package com.abhi245y.watchthis.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuild {

    public static Retrofit retrofitYTS,retrofitTMDb,retrofitJustWacth,retrofitOMDb,retrofitTG;


   public RetrofitBuild(){

   }

   public static Retrofit getRetrofitYTS() {
        String BASE_URL_YTS = "https://yts.mx/api/v2/";
        retrofitYTS = new Retrofit.Builder()
                .baseUrl(BASE_URL_YTS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitYTS;
   }

   public static Retrofit getRetrofitTMDb() {
        String BASE_URL_TMDb = "https://api.themoviedb.org";
        retrofitTMDb = new Retrofit.Builder()
                .baseUrl(BASE_URL_TMDb)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitTMDb;
   }

    public static Retrofit getRetrofitJustWacth() {
        String BASE_URL_JUSTWATCH = "https://apis.justwatch.com/content/titles/en_IN/";
        retrofitJustWacth = new Retrofit.Builder()
                .baseUrl(BASE_URL_JUSTWATCH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitJustWacth;
    }

    public static Retrofit getRetrofitOMDb() {
       String BASE_URL_OMDb = "https://www.omdbapi.com/";
       retrofitOMDb = new Retrofit.Builder()
               .baseUrl(BASE_URL_OMDb)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       return retrofitOMDb;
    }

    public static Retrofit getRetrofitTG() {
        String BASE_URL_TG = "https://tgmoviesbot.sitein.org/search.php/";
        retrofitTG = new Retrofit.Builder()
                .baseUrl(BASE_URL_TG)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitTG;
    }
}
