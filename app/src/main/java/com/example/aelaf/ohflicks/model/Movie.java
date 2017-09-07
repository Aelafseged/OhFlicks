package com.example.aelaf.ohflicks.model;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by aelaf on 9/2/17.
 */

public class Movie {
  public static int ORIO = 1;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    private String image;
    private String description;

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    private String release_date;

    public Movie() {
    }

    //json object to model object
    public Movie(JSONObject jsonObject) {
        super();
        try {



            this.id = (jsonObject.optJSONObject("id")==null)? jsonObject.getInt("id"):0;
            this.release_date = (jsonObject.optJSONObject("release_date")==null)? jsonObject.getString("release_date"):"";

            this.title = (jsonObject.optJSONObject("title")==null)? jsonObject.getString("title"):"Err";
            this.description = (jsonObject.optJSONObject("overview")==null)? jsonObject.getString("overview"):"Err";

            if (ORIO==1) {
                this.image = (jsonObject.optJSONObject("poster_path")==null)? jsonObject.getString("poster_path"):"";

            }
            else if(ORIO==2) {
                this.image = (jsonObject.optJSONObject("backdrop_path")==null)? jsonObject.getString("backdrop_path"):"";

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
//json object array to model object array
    public static ArrayList<Movie> fromJSONmuchLove(JSONArray jsonArray) throws JSONException {
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Movie movie = new Movie(jsonArray.getJSONObject(i));
            movieArrayList.add(movie);
        }
        return movieArrayList;
    }
    public Movie(String title, String image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
