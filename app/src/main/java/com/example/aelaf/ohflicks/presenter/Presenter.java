package com.example.aelaf.ohflicks.presenter;

import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.network.NetworkAdapter;

import java.util.List;

/**
 * Created by aelaf on 9/3/17.
 */

public interface Presenter {
   void loadMovieList();
    void loadMovie();
}
