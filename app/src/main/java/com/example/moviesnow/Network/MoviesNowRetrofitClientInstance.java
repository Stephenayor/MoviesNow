package com.example.moviesnow.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesNowRetrofitClientInstance {
    private static Retrofit retrofit;
    private static String BASE_URL = "https://api.themoviedb.org/";


    public static Retrofit getRetrofitInstance(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();
        }
        return retrofit;
    }
}
