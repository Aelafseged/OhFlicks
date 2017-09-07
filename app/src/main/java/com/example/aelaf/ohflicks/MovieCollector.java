package com.example.aelaf.ohflicks;

import com.example.aelaf.ohflicks.network.NetworkAdapter;

/**
 * Created by aelaf on 9/3/17.
 */

public class MovieCollector implements NetworkAdapter {
    @Override
    public void onDataLoaded(GetMovieCallback callback) {
      // callback.onMovieLoaded();
    }

    @Override
    public void onDataListLoaded(GetListOfMoviesCallback callback) {

    }
}
