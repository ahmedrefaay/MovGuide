package com.example.dell.movies.Network;

import com.example.dell.movies.Network.Model.Movie;
import com.example.dell.movies.Network.Model.Result;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/now_playing")
    Observable<Result>getInTheater(
            @Query("page") int page
    );

    @GET("movie/popular")
    Observable<Result>getPopular(
            @Query("page") int page
    );

    @GET("movie/top_rated")
    Observable<Result>getTopRated(
            @Query("page") int page
    );

    @GET("movie/upcoming")
    Observable<Result>getUpComing(
            @Query("page") int page
    );

    @GET("movie/{movie_id}")
    Single<Movie> getSingleMovie(@Path("movie_id") int id);
}
