package com.example.aelaf.ohflicks.data;

import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.network.NetworkAdapter;

import java.util.List;

/**
 * Created by aelaf on 9/3/17.
 */

public interface MovieDataSource {
    interface GetMoviesListCallBack{
       void onMoviesListLoaded(List<Movie> movieList);
       void onMoviesListNotLoaded();
        void initiateMoviesLoad();
    }
    interface GetMovieCallBack{
        void onMovieLoaded(Movie movie);
        void onMovieNotLoaded();
    }
    void loadMovieList(GetMoviesListCallBack callBack);

    void loadMovie(GetMovieCallBack callBack);
}
