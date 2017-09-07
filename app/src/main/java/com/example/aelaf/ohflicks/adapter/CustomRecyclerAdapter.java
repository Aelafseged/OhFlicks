package com.example.aelaf.ohflicks.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aelaf.ohflicks.MovieDetails;
import com.example.aelaf.ohflicks.R;
import com.example.aelaf.ohflicks.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.media.CamcorderProfile.get;

/**
 * Created by aelaf on 9/6/17.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
        private List<Movie> mMovieList;
        private Context mContext;
    public CustomRecyclerAdapter(Context context,List<Movie> movieList) {
        this.mMovieList = movieList;
        this.mContext = context;
    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.txtTitle.setText(movie.getTitle());
        holder.txtDescription.setText(movie.getDescription());
        holder.progressBar.setVisibility(View.VISIBLE);
        //here comes picasso
        Picasso.with(mContext).load("https://image.tmdb.org/t/p/w342/"+movie.getImage())
                .transform(new RoundedCornersTransformation(10, 10))
                .fit().centerCrop().placeholder(R.drawable.search_cloud).error(R.mipmap.ic_launcher)
                .into(holder.imgMovie, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {
                        if(holder.progressBar!=null)
                            holder.progressBar.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);

                    }
                });


    }


    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.txtTitle) TextView txtTitle;
        @BindView(R.id.txtDescription) TextView txtDescription;
        @BindView(R.id.progressImg) ProgressBar progressBar;
        @BindView(R.id.imgposter)  ImageView imgMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Movie movie = mMovieList.get(position);
                int movieId = movie.getId();
                // We can access the data within the views
                Intent intent = new Intent(mContext, MovieDetails.class);
                intent.putExtra("id",movieId);
                mContext.startActivity(intent);
                Toast.makeText(mContext, movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
