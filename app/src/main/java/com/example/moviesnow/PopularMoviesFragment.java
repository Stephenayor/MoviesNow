package com.example.moviesnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.moviesnow.Model.MovieResult;
import com.example.moviesnow.Model.PopularMovies;
import com.example.moviesnow.Network.MoviesApi;
import com.example.moviesnow.Network.MoviesNowRetrofitClientInstance;

import java.util.ArrayList;
import java.util.Collections;
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

          MoviesApi moviesApiService = MoviesNowRetrofitClientInstance.getRetrofitInstance().create(MoviesApi.class);
          Call <PopularMovies> call = moviesApiService.getAllPopularMovies();
            Log.d("API CALL", "Show movie List");


        call.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                progressDialog.dismiss();
                generatePopularMoviesList(response.body().getMovieResultList());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something Went Wrong" + t.getMessage(), Toast.LENGTH_LONG).show();
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