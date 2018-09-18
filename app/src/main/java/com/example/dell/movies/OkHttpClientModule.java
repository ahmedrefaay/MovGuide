package com.example.dell.movies;

import com.example.dell.movies.App.Const;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpClientModule {

    @Provides
    @Singleton
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor , Interceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public Interceptor interceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl httpUrlTMP = original.url();

                HttpUrl httpUrl = httpUrlTMP.newBuilder().addQueryParameter("api_key" , Const.getApiKey())
                        .addEncodedQueryParameter("language" , Const.getLanguageString())
                        .addEncodedQueryParameter("region" , Const.getIso3661Region())
                        .build();

                Request.Builder requestBuilder = original.newBuilder().url(httpUrl);
                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        };
    }
}
