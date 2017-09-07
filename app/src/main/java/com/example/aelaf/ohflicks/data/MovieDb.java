package com.example.aelaf.ohflicks.data;

import android.util.Log;

import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.network.MovieDbRestClient;
import com.example.aelaf.ohflicks.util.APIUtil;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.example.aelaf.ohflicks.model.Movie.fromJSONmuchLove;

/**
 * Created by aelaf on 9/3/17.
 */

public class MovieDb implements MovieDataSource{

    private static final String TAG = "MovieDb";
    public MovieDb() {
    }

    @Override
    public void loadMovieList(final GetMoviesListCallBack callBack) {
        MovieDbRestClient.get(APIUtil.getPath(), null, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                callBack.initiateMoviesLoad();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i(TAG, "onFailure: "+statusCode);
                callBack.onMoviesListNotLoaded();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                //json object
                Log.i(TAG, "onSuccess: "+response.toString());
                try {
                    JSONArray jsonArray =  response.getJSONArray("results");
                    //3rd way
                    List<Movie> movieList ;

                    Movie movie = new Movie();
                  movieList =  movie.fromJSONmuchLove(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //2nd way
                    /*   Movie movie =  new Movie(jsonObject);
                       String title = movie.getTitle();
                        String image = movie.getImage();
                        String description = movie.getDescription();
                       */
                    /*
                        //work with the rest of model class
                       String title =  jsonObject.getString("title");
                        String image = jsonObject.getString("poster_image");
                        String description = jsonObject.getString("overview");
                        Movie movie= new Movie(title,image,description);
                           movieList.add(movie);

                        //object*/

                    }
                    callBack.onMoviesListLoaded(movieList);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Movie  movie = new Movie(response) ;
            }
           /* @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //json array object
                if(response.optJSONObject("")!=null)
                Log.i(TAG, "onSuccess:Lists ");
                List<Movie> movieList  = new ArrayList<>();
                try {
                     movieList =  new Movie().fromJSONmuchLove(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callBack.onMoviesListLoaded(movieList);


            }*/
        });
    }


    @Override
    public void loadMovie(GetMovieCallBack callBack) {

    }
}
