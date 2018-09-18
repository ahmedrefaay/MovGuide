package com.example.dell.movies;

import com.example.dell.movies.App.Const;
import com.example.dell.movies.Network.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public ApiService apiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient , GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory){

        return new Retrofit.Builder()
                .baseUrl(Const.getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory.create())
                .addCallAdapterFactory(rxJava2CallAdapterFactory.create()).build();
    }

    @Provides
    @Singleton
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory rxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }
}
