package com.example.moviesnow;


import android.os.Bundle;

import com.example.moviesnow.Model.PopularMovies;
import com.example.moviesnow.View.PopularMoviesFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
private PopularMovies popularMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.first_fragment, PopularMoviesFragment.class, null)
                    .commit();

        }
    }

}