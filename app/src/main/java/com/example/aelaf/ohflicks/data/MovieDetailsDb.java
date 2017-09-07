package com.example.aelaf.ohflicks.data;

import android.util.Log;

import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.network.MovieDbRestClient;
import com.example.aelaf.ohflicks.util.APIUtil;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.content.ContentValues.TAG;

/**
 * Created by aelaf on 9/6/17.
 */

public class MovieDetailsDb implements MovieDataSource {

    public int movieId;

    public MovieDetailsDb(int movieid) {
        this.movieId = movieid;
    }

    @Override
    public void loadMovieList(GetMoviesListCallBack callBack) {

    }

    @Override
    public void loadMovie(final GetMovieCallBack callBack) {
        String url = APIUtil.URLMOVIE+ movieId +"?"+APIUtil.API_LINK+APIUtil.API_KEY;
        Log.i(TAG, "loadMovie: "+url);
        MovieDbRestClient.get(url,null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.i("MOVIEDETAILS", "onSuccess: yay");


                    Movie movie = new Movie(response);

                callBack.onMovieLoaded(movie);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i("MOVIEDETAILS", "onFailure:  oh no");
                callBack.onMovieNotLoaded();
            }
        });
    }
}
