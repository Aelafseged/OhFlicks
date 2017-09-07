package com.example.aelaf.ohflicks.network;

import com.example.aelaf.ohflicks.model.Movie;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by aelaf on 9/2/17.
 */

public interface NetworkAdapter {

     interface GetListOfMoviesCallback{
         void onMoviesLoaded(List<Movie> movieList);
         void onMoviesNotLoaded();
     }
     interface GetMovieCallback{
         void onMovieLoaded(Movie movie);
         void onMovieNotLoaded();
     }

    void onDataLoaded(GetMovieCallback callback);
    void onDataListLoaded(GetListOfMoviesCallback callback);
}
