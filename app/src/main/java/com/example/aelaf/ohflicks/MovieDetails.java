package com.example.aelaf.ohflicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aelaf.ohflicks.data.MovieDataSource;
import com.example.aelaf.ohflicks.data.MovieDetailsDb;
import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.presenter.MoviePresenter;
import com.example.aelaf.ohflicks.presenter.Presenter;
import com.example.aelaf.ohflicks.viewer.MovieDbView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.view.View.GONE;

public class MovieDetails extends AppCompatActivity implements MovieDbView {
private int movieId;
    private Presenter mPresenter;
    private MovieDataSource movieDataSource;
    @BindView(R.id.txtMovieDescription) TextView txtMovieDesc;
    @BindView(R.id.imgdetail) ImageView imgMovieDetail;
    @BindView(R.id.txtReleaseDate) TextView txtReleasedate;
    @BindView(R.id.txtRelease) TextView txtRelease;
    @BindView(R.id.imgDetailErr) ImageView imgDetailError;


    @BindView(R.id.progressBarMovieDetail)ProgressBar progressBar;
    // Group the views together




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

      Intent intent = getIntent();
       movieId =  intent.getIntExtra("id",0);
        txtReleasedate.setVisibility(GONE);

        movieDataSource = new MovieDetailsDb(movieId);
        mPresenter = new MoviePresenter(this,movieDataSource);
        mPresenter.loadMovie();

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMovieList(List<Movie> movieList) {

    }

    @Override
    public void showMovieListNot() {

    }

    @Override
    public void showMovie(Movie movie) {
        txtReleasedate.setVisibility(View.VISIBLE);
        txtMovieDesc.setVisibility(View.VISIBLE);
        txtRelease.setVisibility(View.VISIBLE);
       txtMovieDesc.setText(movie.getDescription());
        txtReleasedate.setText(movie.getRelease_date());
        this.setTitle(movie.getTitle());
        Picasso.with(this).load("https://image.tmdb.org/t/p/w342/"+movie.getImage())
                .transform(new RoundedCornersTransformation(10, 10))
                .fit().centerInside().placeholder(R.drawable.search_cloud).error(R.drawable.err_cloud)
                .into(imgMovieDetail, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {
                        if(progressBar!=null)
                            progressBar.setVisibility(GONE);

                    }

                    @Override
                    public void onError() {
                        progressBar.setVisibility(GONE);

                    }
                });
    }

    @Override
    public void showMovieNot() {
        progressBar.setVisibility(GONE);
        imgDetailError.setVisibility(View.VISIBLE);
    }

    @Override
    public void initiate() {

    }
}
