package com.example.aelaf.ohflicks.viewer;

import com.example.aelaf.ohflicks.model.Movie;

import java.util.List;

/**
 * Created by aelaf on 9/3/17.
 */

public interface MovieDbView {

    void showMovieList(List<Movie> movieList);
    void showMovieListNot();
    void showMovie(Movie movie);
    void showMovieNot();
    void initiate();
}
