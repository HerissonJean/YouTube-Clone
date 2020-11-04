package com.example.youtubeclone.helper;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSetup {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder().
                baseUrl(YouTubeSetup.URL_BASE).
                addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
