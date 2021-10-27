package com.example.moviesnow;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviesnow.Model.MovieResult;


public class MovieDetailsFragment extends Fragment {
    public static final String EXTRA_MOVIE = "movies";
    private ImageView imageView;
    private MovieResult movieResult;
    private TextView movieOverview;
    private TextView movieDescription;
    private TextView movieVoteAverage;



    public MovieDetailsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detials, container, false);
        imageView = view.findViewById(R.id.movie_details_image);
        movieOverview = view.findViewById(R.id.movie_overview);
        movieDescription = view.findViewById(R.id.movie_description);
        movieVoteAverage = view.findViewById(R.id.movie_voteaverage);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            movieResult = bundle.getParcelable(EXTRA_MOVIE);
        }else {
            throw new NullPointerException("Movies Detail Fragment must receive a movie parcel");
        }

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/"+
                       movieResult.getPosterPath())
                .into(imageView);

        movieOverview.setText(movieResult.getOverview());
        movieDescription.setText("Release Date:\n"
                + movieResult.getReleaseDate());
        movieVoteAverage.setText("Rating:\n"
                + movieResult.getVoteAverage());
        return view;
    }
}