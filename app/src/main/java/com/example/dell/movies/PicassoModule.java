package com.example.dell.movies;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PicassoModule {

    @Provides
    @Singleton
    public Picasso picasso(@Named("application_context") Context context){
        return new Picasso.Builder(context).build();
    }
}

