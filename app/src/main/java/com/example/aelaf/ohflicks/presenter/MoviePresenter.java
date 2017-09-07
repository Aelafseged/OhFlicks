package com.example.aelaf.ohflicks.presenter;

import android.util.Log;

import com.example.aelaf.ohflicks.data.MovieDataSource;
import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.viewer.MovieDbView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by aelaf on 9/3/17.
 */

public class MoviePresenter implements  Presenter {
    private MovieDbView displayer;
    private MovieDataSource movieDataSource;
    public MoviePresenter(MovieDbView mainActivity, MovieDataSource movieDataSource) {
        displayer = mainActivity;
        this.movieDataSource = movieDataSource;
    }

    @Override
    public void loadMovieList() {
        Log.i(TAG, "loadMovieList: ");

        movieDataSource.loadMovieList(new MovieDataSource.GetMoviesListCallBack() {
            @Override
            public void onMoviesListLoaded(List<Movie> movieList) {
                Log.i(TAG, "onMoviesListLoaded: ");
                displayer.showMovieList(movieList);
            }

            @Override
            public void onMoviesListNotLoaded() {
                Log.i(TAG, "onMoviesListNotLoaded: ");
                displayer.showMovieListNot();
            }

            @Override
            public void initiateMoviesLoad() {
                displayer.initiate();
            }
        });
    }

    @Override
    public void loadMovie() {
        movieDataSource.loadMovie(new MovieDataSource.GetMovieCallBack() {
            @Override
            public void onMovieLoaded(Movie movie) {
                displayer.showMovie(movie);
            }

            @Override
            public void onMovieNotLoaded() {
                displayer.showMovieNot();
            }
        });
    }

}
