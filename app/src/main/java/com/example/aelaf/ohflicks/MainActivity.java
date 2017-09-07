package com.example.aelaf.ohflicks;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aelaf.ohflicks.adapter.CustomRecyclerAdapter;
import com.example.aelaf.ohflicks.adapter.MyMovieAdapter;
import com.example.aelaf.ohflicks.data.MovieDataSource;
import com.example.aelaf.ohflicks.data.MovieDb;
import com.example.aelaf.ohflicks.model.Movie;
import com.example.aelaf.ohflicks.presenter.MoviePresenter;
import com.example.aelaf.ohflicks.presenter.Presenter;
import com.example.aelaf.ohflicks.viewer.MovieDbView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity implements MovieDbView {
    private static final String TAG ="ERROR" ;
   // private ListView listView;
   // private TextView imageView;
    private Presenter mPresenter;
 //private MyMovieAdapter movieAdapter;

    private CustomRecyclerAdapter customRecyclerAdapter;

   private RecyclerView.LayoutManager layoutManager;


    // private ProgressBar prgBar;
    //Good bye listview :~~(
    //@BindView(R.id.lstView) ListView listView;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @BindView(R.id.imgnone) ImageView imageView;
    @BindView(R.id.progressBar)ProgressBar prgBar;
    //Presenter class and other things
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        //pick the orientation LANDSCAPE OR PORTRAIT
      int orientation =   getResources().getConfiguration().orientation;
        Movie.ORIO = orientation;
        prgBar.setVisibility(android.view.View.INVISIBLE);
            MovieDataSource movieDataSource = new MovieDb();
            mPresenter = new MoviePresenter(this, movieDataSource);

            mPresenter.loadMovieList();

    }
  /*  public String getRotation(Context context){
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
                return "portrait";
            case Surface.ROTATION_90:
                return "landscape";
            case Surface.ROTATION_180:
                return "reverse portrait";
            default:
                return "reverse landscape";
        }
    }*/

    @Override
    public void showMovieList(List<Movie> movieList) {
       /* movieAdapter = new MyMovieAdapter(this,movieList);
        listView.setAdapter(movieAdapter);*/
       //FARE WELL OLD FRIEND!!! listView :-( :-( :-(

         customRecyclerAdapter = new CustomRecyclerAdapter(this,movieList);
        recyclerView.setAdapter(customRecyclerAdapter);


            layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        prgBar.setVisibility(android.view.View.INVISIBLE);

    }

    @Override
    public void showMovieListNot() {
        prgBar.setVisibility(android.view.View.INVISIBLE);
        imageView.setVisibility(TextView.VISIBLE);
    }

    @Override
    public void showMovie(Movie movie) {

    }

    @Override
    public void showMovieNot() {


    }

    @Override
    public void initiate() {
       prgBar.setVisibility(android.view.View.VISIBLE);
    }
}
