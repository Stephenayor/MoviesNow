package com.example.moviesnow;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
import java.util.List;


public class PopularMoviesFragment extends Fragment {
private ProgressDialog progressDialog;
private RecyclerView recyclerview;
private MovieResult movieResult;
private List<PopularMovies> popularMoviesList = new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("IMAGES ARE LOADING. . .");
        progressDialog.show();
        final View view = inflater.inflate(R.layout.popular_movies, container, false);
        recyclerview = view.findViewById(R.id.popularMovies_recyclerView);

          MoviesApi moviesApiService = MoviesNowRetrofitClientInstance.getRetrofitInstance().create(MoviesApi.class);
          Call <List<PopularMovies>> call = moviesApiService.getAllPopularMovies();
            Log.d("API CALL", "Show movie List");

        call.enqueue(new Callback<List<PopularMovies>>() {
            @Override
            public void onResponse(Call<List<PopularMovies>> call, Response<List<PopularMovies>> response) {
                progressDialog.dismiss();
         //      Toast.makeText(getContext(), "yo movie "+ response.body().getOriginalTitle(), Toast.LENGTH_LONG).show();
                generatePopularMoviesList(response.body());

            }

            @Override
            public void onFailure(Call<List<PopularMovies>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something Went Wrong" + t.getMessage(), Toast.LENGTH_LONG).show();
            }

            private void generatePopularMoviesList(List<PopularMovies> MoviesList) {
                recyclerview.setHasFixedSize(true);
                recyclerview.setLayoutManager(new GridLayoutManager(view.getContext(),3));
                recyclerview.setAdapter(new PopularMoviesAdapter(view.getContext(), movieResult, popularMoviesList));
            }
        });
        return view;

    }

}