package com.example.aelaf.ohflicks.util;

/**
 * Created by aelaf on 9/2/17.
 */

public class APIUtil {
    public static final String API_KEY = "9f319b9a93128a8088ef0e9d56f14bb0";
    public static final String API_KEY2 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZjMxOWI5YTkzMTI4YTgwODhlZjBlOWQ1NmYxNGJiMCIsInN1YiI6IjU5YTljYjIzOTI1MTQxNDc0MTAwMGUyNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1_xJrN4AECNDuUD51YjPCPquTpxRDgQxBK34Sbhunt8";
    public static final String URL = "https://api.themoviedb.org/3/movie/now_playing?";
    public static final String URLMOVIE = "https://api.themoviedb.org/3/movie/";

    public static final String TOKEN = "dff52f0b10f54697cc45744f882b70cc4f3f4334";
    public static final String TOKEN_LINK ="";
    public static final String API_LINK = "api_key=";
    public static String getPath(){
        return URL+API_LINK+API_KEY;
    }
   /* public static String getPa(){
        return API_LINK+
    }*/

}
