package com.example.dell.movies;

import android.support.v4.app.Fragment;

import com.example.dell.movies.Network.ApiClient;
import com.example.dell.movies.Network.ApiService;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {ApiModule.class , PicassoModule.class})
@Singleton
public interface MovieComponent {

    ApiService getApiService();
    Picasso getPicasso();

}
