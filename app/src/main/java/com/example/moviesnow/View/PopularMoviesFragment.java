package com.example.moviesnow.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviesnow.Model.MovieResult;
import com.example.moviesnow.Model.PopularMovies;
import com.example.moviesnow.PopularMoviesAdapter;
import com.example.moviesnow.R;
import com.example.moviesnow.Viewmodel.PopularMoviesViewmodel;

import java.util.ArrayList;
import java.util.List;


public class PopularMoviesFragment extends Fragment implements PopularMoviesAdapter.ItemClickListener {
    private static final String MOVIES = "movieResult";
    private ProgressDialog progressDialog;
    private RecyclerView recyclerview;
    private PopularMoviesAdapter adapter;
    private List<MovieResult> movieResult = new ArrayList<MovieResult>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) { 
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(MOVIES, (ArrayList<? extends Parcelable>) movieResult);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_movies, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("IMAGES ARE LOADING. . .");
        progressDialog.show();
        recyclerview = view.findViewById(R.id.popularMovies_recyclerView);


        PopularMoviesViewmodel popularMoviesViewmodel = new PopularMoviesViewmodel();
        popularMoviesViewmodel.getPopularMovies().observe(getViewLifecycleOwner(), new Observer<PopularMovies>() {
            @Override
            public void onChanged(PopularMovies popularMovies) {
                progressDialog.dismiss();
                generatePopularMoviesList(popularMovies.getMovieResultList());
            }
        });

        return view;
    }
        private void generatePopularMoviesList(List<MovieResult> movies) {
        adapter = new PopularMoviesAdapter(getContext(), movies, this);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onMovieItemClick(MovieResult movie) {
        Fragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("movies", movie);
        movieDetailsFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().remove(new PopularMoviesFragment())
                .replace(R.id.first_fragment, movieDetailsFragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}