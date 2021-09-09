package com.example.moviesnow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moviesnow.Model.MovieResult;
import com.example.moviesnow.Model.PopularMovies;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder> {
private MovieResult movieResult;
private LayoutInflater layoutInflater;
private Context context;
private List<PopularMovies> moviesList;
private List<MovieResult> movieResultList = new ArrayList<>();

    public PopularMoviesAdapter(Context context, MovieResult movies, List<PopularMovies> popularMoviesList) {
    this.movieResult = movies;
    this.context = context;
    this.moviesList = popularMoviesList;
    this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.popular_movies, parent,false);
        return new PopularMoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoviesViewHolder holder, int position) {
        Glide.with(context)
                .load(movieResultList.get(position).getPosterPath())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class PopularMoviesViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public PopularMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.popularMovies_image_view);

        }


    }
}
