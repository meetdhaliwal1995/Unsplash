package com.example.demomeme;

import com.example.demomeme.ModelCategory.CategoryMeme;
import com.example.demomeme.ModelChannel.GetChannel;
import com.example.demomeme.ModelLogin.UserLogin;
import com.example.demomeme.ModelRegister.UserRegister;
import com.example.demomeme.ModelLogin.ListLogin;
import com.example.demomeme.SingleChannel.SingelChannelList;
import com.example.demomeme.SingleChannel.SingleChannel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

        @GET(Constant.CATEGORY_MEME)
        Call<CategoryMeme> getMemeCategory();

        @GET(Constant.USER_REGISTER)
        Call<UserRegister> getUserRegister(@Query("name")String name, @Query("email")String email, @Query("password")String password, @Query("phone")String phone);

        @GET(Constant.USER_LOGIN)
        Call<UserLogin> getUserLogin(@Query("email")String email, @Query("password")String password);

        @GET(Constant.CHANNEL_MEME)
        Call<GetChannel> getChannel(@Query("get_channels_by_cat_id")String id);

        @GET(Constant.CHANNEL_MEME)
        Call<SingleChannel> getSingelChannel(@Query("get_single_channel_id")String id);

}
