package com.example.aelaf.ohflicks.network;

import android.util.Log;

import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.presenter.Presenter;
import com.example.aelaf.ohflicks.util.APIUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.content.ContentValues.TAG;
import static android.media.CamcorderProfile.get;
import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by aelaf on 9/2/17.
 */

public class MovieDbRestClientUsage
{
   private List<Movie> movieList;
    private    Movie movie;
    NetworkAdapter mNetworkAdapter;
    public MovieDbRestClientUsage(NetworkAdapter networkAdapter) {
        this.mNetworkAdapter = networkAdapter;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void getMovieTimeLineList() throws JSONException{
        MovieDbRestClient.get("https://api.themoviedb.org/3/movie/now_playing?api_key=9f319b9a93128a8088ef0e9d56f14bb0", null, new JsonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i(TAG, "onFailure: "+statusCode);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                //json object
                movie = new Movie(response) ;
                Log.i(TAG, "onSuccess: "+movie.getTitle());



                 }
      @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //json array object
                Log.i(TAG, "onSuccess:Lists ");
                try {
                    List<Movie> movieList =  new Movie().fromJSONmuchLove(response);
                    Log.i(TAG, "onSuccess: List of "+movieList.size());
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }


}
