package com.example.aelaf.ohflicks.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aelaf.ohflicks.MainActivity;
import com.example.aelaf.ohflicks.MovieDetails;
import com.example.aelaf.ohflicks.R;
import com.example.aelaf.ohflicks.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.R.attr.resource;
import static android.content.ContentValues.TAG;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by aelaf on 9/2/17.
 */

public class MyMovieAdapter extends ArrayAdapter<Movie> {
private Context mContext;
     static class ViewHolder {
       @BindView(R.id.txtTitle) TextView txtTitle;
        @BindView(R.id.txtDescription) TextView txtDescription;
        @BindView(R.id.progressImg) ProgressBar progressBar;
        @BindView(R.id.imgposter) ImageView imgMovie;


        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
    public MyMovieAdapter(@NonNull Context context, List<Movie> movieList) {
        super(context, 0,movieList);
        mContext = context;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //magic of populating list of movie items
        Movie movie = getItem(position);
       final ViewHolder viewHolder;
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_movie_list,parent,false);
            viewHolder = new ViewHolder(convertView);


            convertView.setTag(viewHolder);
            viewHolder.txtDescription.setTag(position);
        }
        else{
        viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtTitle.setText(movie.getTitle());
        viewHolder.progressBar.setVisibility(View.VISIBLE);

        Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w342/"+movie.getImage())
                .transform(new RoundedCornersTransformation(10, 10))
                .fit().centerCrop().placeholder(R.drawable.search_cloud).error(R.mipmap.ic_launcher)
                .into(viewHolder.imgMovie, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {
                        if(viewHolder.progressBar!=null)
                        viewHolder.progressBar.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError() {
                        viewHolder.progressBar.setVisibility(View.GONE);

                    }
                });
       // Picasso.with(getContext()).load(movie.getImage()).fit().centerCrop().into(viewHolder.imgMovie);
        viewHolder.txtDescription.setText(movie.getDescription());
       // viewHolder.imgMovie.setBackground(R.mipmap.ic_launcher);
        //event handler
        viewHolder.txtDescription.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
              int pos = (Integer)  view.getTag();
                Movie selectedMovie = getItem(pos);

                Intent intent = new Intent(mContext,MovieDetails.class);
                intent.putExtra("id",selectedMovie.getId());
                Log.i(TAG, "onClick: "+pos);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
