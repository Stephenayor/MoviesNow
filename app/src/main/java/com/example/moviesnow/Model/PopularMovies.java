package com.example.moviesnow.Model;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PopularMovies implements Parcelable
{
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<MovieResult> movieResultList = null;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    public final static Creator<PopularMovies> CREATOR = new Creator<PopularMovies>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PopularMovies createFromParcel(android.os.Parcel in) {
            return new PopularMovies(in);
        }

        public PopularMovies[] newArray(int size) {
            return (new PopularMovies[size]); }
        };

    protected PopularMovies(android.os.Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.movieResultList, (com.example.moviesnow.Model.MovieResult.class.getClassLoader()));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public PopularMovies() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieResult> getMovieResultList() {
        return movieResultList;
    }

    public void setMovieResultList(List<MovieResult> movieResultList) {
        this.movieResultList = movieResultList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeList(movieResultList);
        dest.writeValue(totalPages);
        dest.writeValue(totalResults);
    }

    public int describeContents() {
        return  0;
    }

}
