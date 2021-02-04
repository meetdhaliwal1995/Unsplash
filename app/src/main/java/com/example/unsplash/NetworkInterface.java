package com.example.unsplash;

import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.example.unsplash.ModelApi.Download.DownloadPic;
import com.example.unsplash.ModelApi.UserData.UserPhoto;
import com.example.unsplash.ModelApi.UserProfile.UserProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {


    @GET(Constant.PHOTOS)
    Call<List<AllPhoto>> getAllPhotos(@Query("page") String page, @Query("client_id") String key);

    @GET(Constant.USERINFO)
    Call<List<UserPhoto>> getUserInfo(@Path(value = "username", encoded = true) String username, @Query("page") String page, @Query("client_id") String key);

    @GET(Constant.USERPROFILE)
    Call<UserProfile> getUserProfile(@Path(value = "username", encoded = true) String username, @Query("client_id") String key);

    @GET(Constant.DOWNLOAD)
    Call<DownloadPic> getDownload(@Path(value = "download", encoded = true) String url, @Query("client_id") String key);
}
