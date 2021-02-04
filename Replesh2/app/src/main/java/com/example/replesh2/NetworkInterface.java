package com.example.replesh2;

import com.example.replesh2.model.ChannelData;
import com.example.replesh2.Video.VideoData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkInterface {
    @GET("imp/api.php?get_category")
    Call<VideoData> listCats();

    @GET("imp/api.php?get_all_channels")
    Call<ChannelData> listChannel();

}
