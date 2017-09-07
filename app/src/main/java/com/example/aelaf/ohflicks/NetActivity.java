package com.example.aelaf.ohflicks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aelaf.ohflicks.network.MovieDbRestClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cz.msebera.android.httpclient.Header;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class NetActivity extends AppCompatActivity {
    private static final String TAG ="NETaCT" ;
    private TextView txtview;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtview = (TextView)findViewById(R.id.txtnet);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        setSupportActionBar(toolbar);

//netCall();
        oldnetCall();
    }

    private void oldnetCall() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://172.16.16.16", new AsyncHttpResponseHandler() {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
            }

            @Override
            public void onStart() {
                // called before request is started
                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                Toast.makeText(NetActivity.this, "Success: "+statusCode, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, error404)
                Toast.makeText(NetActivity.this, "Failure: "+statusCode, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
                Toast.makeText(NetActivity.this, "Retry: "+retryNo, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void netCall() {
        MovieDbRestClient.get("http://172.16.16.16", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
              // super.onSuccess(statusCode, headers, response);
                txtview.setText(statusCode+"");
                Toast.makeText(NetActivity.this, "some yet", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
               // super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(NetActivity.this, "nothing yet", Toast.LENGTH_SHORT).show();


            }
            /* @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                txtview.setText(i+"");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(NetActivity.this, "nothing yet", Toast.LENGTH_SHORT).show();
            }*/
        });
    }

}
