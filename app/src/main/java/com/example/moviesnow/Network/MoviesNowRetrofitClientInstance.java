package com.example.moviesnow.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesNowRetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=e39dd47477f4bd2ccf8277df82b9f616";
    private static String baseUrl = "https://api.themoviedb.org/";



    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()

                    .baseUrl(baseUrl)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
