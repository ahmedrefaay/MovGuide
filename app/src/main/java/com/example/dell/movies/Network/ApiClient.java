package com.example.dell.movies.Network;

import android.content.Context;

import com.example.dell.movies.App.Const;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static int REQUEST_TIME_OUT = 90;
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static Retrofit getApiClient(Context context) {

        if (okHttpClient == null) {
            CreateokhttpClient();
        }
        if (retrofit == null) {

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Const.getBaseUrl())
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

            retrofit = builder.build();

        }
        return retrofit;
    }

    private static void CreateokhttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(REQUEST_TIME_OUT , TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIME_OUT , TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
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
                });
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        okHttpClient = builder.build();
    }
}
