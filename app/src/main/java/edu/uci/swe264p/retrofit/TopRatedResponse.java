package edu.uci.swe264p.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedResponse {

    //Copied from Movie...This is what recieves the API response from MovieAPIService
    //results is the tag in the JSON That contains the movie array. Thanks to GSON to take
    //care of everything from converting between movie  and List<Movie> from the array of
    //movies in JSON.
    @SerializedName("results")
    private List<Movie> topMoviesList;


    public TopRatedResponse(List<Movie> incomingMovies) {
        this.topMoviesList = incomingMovies;

    }

    public List<Movie> getTopMoviesList() {
        return topMoviesList;
    }
}
