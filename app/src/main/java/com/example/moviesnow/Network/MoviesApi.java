package com.example.moviesnow.Network;

import android.database.Observable;

import com.example.moviesnow.Model.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MoviesApi {
    String key = "e39dd47477f4bd2ccf8277df82b9f616";
    String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=e39dd47477f4bd2ccf8277df82b9f616";
    @GET("3/movie/550?api_key=e39dd47477f4bd2ccf8277df82b9f616")

    Call<List<Movies>>getAllPopularMovies();

}
