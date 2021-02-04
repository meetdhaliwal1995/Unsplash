package com.example.retrofit;

import com.example.retrofit.Profile.Profile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkInterface {

    @GET("users/repos")
    Call<Profile> profile();
}
