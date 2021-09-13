package com.example.moviesnow.Network;

import com.example.moviesnow.Model.MovieResult;
import com.example.moviesnow.Model.PopularMovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {
    String key = "e39dd47477f4bd2ccf8277df82b9f616";
    String popularMoviesKey = "e39dd47477f4bd2ccf8277df82b9f616&language=en-US&page=1";

    @GET("3/movie/popular?api_key="+popularMoviesKey)
    Call <PopularMovies> getAllPopularMovies();

//    @GET("3/movie/550?api_key="+key)
//    Call <List<Movie>> getMovie();

}
