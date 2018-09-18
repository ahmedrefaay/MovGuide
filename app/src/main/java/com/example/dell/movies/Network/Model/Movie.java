package com.example.dell.movies.Network.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie implements Parcelable{

    public Movie(){

    }
    public void Movie_assign(Movie movie){
        this.id = movie.id;
        this.title = movie.getTitle();
        this.posterPath = movie.posterPath;
        this.backdropPath = movie.backdropPath;
        this.voteAverage = movie.voteAverage;
        this.overView = movie.overView;
        this.releaseDate = movie.releaseDate;
        this.genres = movie.genres;
    }
    int id;

    @SerializedName("vote_average")
    float voteAverage;

    @SerializedName("title")
    String title;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("overview")
    String overView;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("runtime")
    String time;

    @SerializedName("tagline")
    String tagLine;

    @SerializedName("genres")
    ArrayList<Category> genres;

    public String getTime() {
        if(TextUtils.isEmpty(time))
        {
            return "N/A";
        }
        else{
            return time + "min";
        }
    }

    public String getGenres() {
        String gen = "";
        int i;
        for( i = 0 ; i < genres.size() ; i++){
            if( i == genres.size() - 1){
                gen += genres.get(i).name;

            }
            else{
                gen += genres.get(i).name + "\\";
            }

        }
        return gen;
    }
    public String getTagLine() { return tagLine; }

    public int getId() {
        return id;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOverView() {
        return overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        voteAverage = in.readFloat();
        title = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        overView = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(voteAverage);
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeString(overView);
        dest.writeString(releaseDate);
    }
}
