package com.abhi245y.watchthis.Services;

import com.abhi245y.watchthis.Models.TMDbGetImagesModel;
import com.abhi245y.watchthis.Models.TMDbIDModel;
import com.abhi245y.watchthis.Models.TMDbMovieSearchModel;
import com.abhi245y.watchthis.Models.TMDbPopularModel;
import com.abhi245y.watchthis.Models.TMDbSimilarMoviesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDbService {
    @GET("3/movie/{popular}")
    Call<TMDbPopularModel> getTMDbPopular(@Path("popular") String type,
                                          @Query("api_key") String api_key,
                                          @Query("language") String language,
                                          @Query("page") int page,
                                          @Query("region") String region);

    @GET("3/search/movie")
    Call<TMDbMovieSearchModel> searchTMDb(@Query("api_key") String api_key,
                                          @Query("query") String movie_name,
                                          @Query("page") int page);

    @GET("3/movie/{movie_id}/external_ids")
    Call<TMDbIDModel> getTMDbID(@Path("movie_id") String movie_id, @Query("api_key") String api_key);

    @GET("3/movie/{movie_id}/images")
    Call<TMDbGetImagesModel> getImages(@Path("movie_id") String movie_id,
                                          @Query("api_key") String api_key);

    @GET("3/movie/{movie_id}/recommendations")
    Call<TMDbSimilarMoviesModel> getSimilarMovies(@Path("movie_id") String movie_id,@Query("api_key") String app_id);

}
