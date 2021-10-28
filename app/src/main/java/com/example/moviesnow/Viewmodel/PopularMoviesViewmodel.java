package com.example.moviesnow.Viewmodel;

import com.example.moviesnow.Model.PopularMovies;
import com.example.moviesnow.PopularMoviesRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PopularMoviesViewmodel extends ViewModel{
    private PopularMoviesRepository popularMoviesRepository;
    private MutableLiveData<PopularMovies> mutableLiveData;

    public PopularMoviesViewmodel(){
        popularMoviesRepository = new PopularMoviesRepository();
    }

    public LiveData<PopularMovies> getPopularMovies() {
        if(mutableLiveData==null){
            mutableLiveData = popularMoviesRepository.requestPopularMovies();
        }
        return mutableLiveData;
}
}
