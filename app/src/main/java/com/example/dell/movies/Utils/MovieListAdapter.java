package com.example.dell.movies.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.movies.App.Const;
import com.example.dell.movies.Network.Model.Movie;
import com.example.dell.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.Myviewholder> {

    Context context;
    ArrayList<Movie> movies = new ArrayList<>();
    int imageSize;
    Picasso picasso;

    public MovieListAdapter(Context context, ArrayList<Movie> movies , Picasso picasso) {

        this.context = context;
        this.movies = movies;
        this.picasso = picasso;
        this.imageSize = ImageSizeHandling.getImageSize(context);
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.movie_row, parent, false);

        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        if (movies.get(position).getPosterPath() != null) {
            picasso
                    .load(Const.getBasePosterPath(movies.get(position).getPosterPath()))
                    .resize(imageSize, imageSize + 200)
                    .into(holder.imageView);
        }
        else {
            picasso
                    .load(R.drawable.poster_placeholder)
                    .resize(imageSize, imageSize + 200)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.Movie_Image)
        ImageView imageView;

        public Myviewholder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
