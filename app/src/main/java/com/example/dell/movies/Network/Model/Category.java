package com.example.dell.movies.Network.Model;

import com.google.gson.annotations.SerializedName;

public class Category {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
