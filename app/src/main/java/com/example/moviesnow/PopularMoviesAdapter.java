package com.example.moviesnow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviesnow.Model.MovieResult;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder> {
private List<MovieResult> movies;
private LayoutInflater layoutInflater;
private Context context;


    public PopularMoviesAdapter(Context context, List<MovieResult> popularMovies) {
    this.context = context;
    this.movies = popularMovies;
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
        if (movies.get(position) != null) {
//            Glide.with(context)
//                    .load(movies.get(position).getPosterPath())
//                    .into(holder.imageView);
                    Log.d("TAG", "movie object" + movies.get(position).getOriginalTitle());
            holder.textView.setText("movies.get(position).getOriginalTitle()");
        }
    }

    @Override
    public int getItemCount() {
        if (movies==null){
            return 0;
        }
        return movies.size();
    }

    public class PopularMoviesViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public PopularMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.popularMovies_image_view);
            textView = itemView.findViewById(R.id.movies_textView);
        }


    }
}
