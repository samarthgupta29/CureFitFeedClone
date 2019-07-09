package com.example.curefitfeed.APIHelper;

import com.example.curefitfeed.Model.UnsplashImagePOJO;
import com.example.curefitfeed.Model.UnsplashImageResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashImageAPI {

    @GET("/photos/random")
    Call<List<UnsplashImagePOJO>> getImages(@Query("count")int count, @Query("client_id") String client_id);

}
