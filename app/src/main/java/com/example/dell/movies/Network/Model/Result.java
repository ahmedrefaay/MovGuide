package com.example.dell.movies.Network.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {

    @SerializedName("results")
    ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
