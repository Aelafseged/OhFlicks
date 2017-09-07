package com.example.aelaf.ohflicks.network;

import com.example.aelaf.ohflicks.util.APIUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by aelaf on 9/2/17.
 */

public class MovieDbRestClient {
    //hast to be static
    //api address of the moviedb...
    private static String BASE_URL = APIUtil.URL;
    private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    public static void get(String relativeUrl, RequestParams requestParams, AsyncHttpResponseHandler handler){
        asyncHttpClient.get(relativeUrl,requestParams,handler);
    }
    public static void put(String relativeURL,RequestParams requestParams,AsyncHttpResponseHandler handler){
        asyncHttpClient.put(getAbsolutePath(relativeURL),requestParams,handler);
    }
    private static void post(String relativeURL,RequestParams requestParams,AsyncHttpResponseHandler handler){
        asyncHttpClient.post(getAbsolutePath(relativeURL),requestParams,handler);
    }
    //absolute path
    private static String getAbsolutePath(String relativeurl){
        return BASE_URL+relativeurl;
    }

}
