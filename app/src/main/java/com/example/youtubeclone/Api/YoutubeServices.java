package com.example.youtubeclone.Api;

import com.example.youtubeclone.Model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeServices {


    /*
    *  https://www.googleapis.com/youtube/v3/
    *  search
    *  ?part=snippet
    *  &order=date
    *  &maxResults=20
    *  &key=AIzaSyAweRCGrhOlo-Ld4-X_YMWmlBq540P7aoc
    *  &channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
    */

    /*
    *  https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=20&key=AIzaSyAweRCGrhOlo-Ld4-X_YMWmlBq540P7aoc&channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
    */


    @GET("search")
    Call<Resultado> recuperarVideos(
            @Query("part")  String part,
            @Query("order") String order,
            @Query("maxResults") String maxResults,
            @Query("key") String key,
            @Query("channelId") String channelId

    );

}
