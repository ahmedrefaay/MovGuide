package com.example.dell.movies;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context)
    {
        this.context = context;
    }

    @Named("application_context")
    @Provides
    @Singleton
    public Context context(){
        return context.getApplicationContext();
    }
}
