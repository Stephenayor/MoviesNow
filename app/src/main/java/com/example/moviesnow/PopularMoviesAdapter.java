package com.example.moviesnow;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviesnow.Model.MovieResult;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder> {
private List<MovieResult> movies;
private LayoutInflater layoutInflater;
private Context context;
private ItemClickListener movieClickListener;


    public PopularMoviesAdapter(Context context, List<MovieResult> popularMovies, ItemClickListener clickListener) {
    this.context = context;
    this.movies = popularMovies;
    this.movieClickListener = clickListener;
    this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.from(parent.getContext()).inflate(R.layout.popularmovies_imagelist_item, parent,false);
        return new PopularMoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoviesViewHolder holder, int position) {
        if (movies.get(position) != null) {
            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w500/" +
                            movies.get(position).getPosterPath())
                    .into(holder.imageView);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            movieClickListener.onMovieItemClick(movies.get(position));
                        }
                    });
        }
    }


    @Override
    public int getItemCount() {
        if (movies==null){
            return 0;
        }
        return movies.size();
    }

    public class PopularMoviesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public PopularMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.popularMovies_image_view);
        }

    }
        public interface ItemClickListener{
        void onMovieItemClick(MovieResult movieResult);
        }
}
