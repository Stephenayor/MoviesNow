package com.example.moviesnow;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.moviesnow.Model.PopularMovies;
import com.example.moviesnow.Network.MoviesApi;
import com.example.moviesnow.Network.MoviesNowRetrofitClientInstance;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMoviesRepository {
    private ProgressDialog progressDialog;
    public MutableLiveData<PopularMovies> requestPopularMovies(){
        final MutableLiveData<PopularMovies> mutableLiveData = new MutableLiveData<>();

        MoviesApi moviesApiService = MoviesNowRetrofitClientInstance.getRetrofitInstance().create(MoviesApi.class);
        Call<PopularMovies> call = moviesApiService.getAllPopularMovies();
        Log.d("Repository call", "is Successful");
        call.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                mutableLiveData.setValue(response.body());
                Log.d("Repository call", "is Successful");
            }

            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {
                progressDialog.dismiss();
                t.getMessage();

            }
        });

        return mutableLiveData;
    }

}
