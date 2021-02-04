package com.example.ammdhillon;

import com.example.ammdhillon.AllVideos.AllVideos;
import com.example.ammdhillon.ModelAllChannel.AllChannelList;
import com.example.ammdhillon.ModelAppDetail.AppDetail;
import com.example.ammdhillon.ModelChannel.Channel;
import com.example.ammdhillon.ModelClass.CategoryParent;
import com.example.ammdhillon.ModelProfileUpdate.UpdateData;
import com.example.ammdhillon.ModelResetPassword.ForgotPassword;
import com.example.ammdhillon.ModelSingle.SingleChannel;
import com.example.ammdhillon.ModelUserLogin.UserLogin;
import com.example.ammdhillon.ModelUserProfile.UserProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET(Constant.CATEGORY_LIST)
    Call<CategoryParent> getCategory();

    @GET(Constant.CHANNEL_CAT)
    Call<Channel> getChannel(@Query("get_channels_by_cat_id") String id);

    @GET(Constant.CHANNEL_CAT)
    Call<SingleChannel> getSingle(@Query("get_single_channel_id")String string);

    @GET(Constant.ALL_CHANNEL)
    Call<AllChannelList> gelAllChannel();

    @GET(Constant.ALL_VIDEO)
    Call<AllVideos> getAllVideo();

    @GET(Constant.USER_PROFILE)
    Call<UserProfile> getUserProfile(@Query("get_user_profile") String s);

    @GET(Constant.CHANNEL_CAT)
    Call<AppDetail> getAppDetail();

    @GET(Constant.CHANNEL_CAT)
    Call<Channel> getSearchChannels(@Query("get_search_channels")String id);

    @GET(Constant.USER_LOGIN)
    Call<UserLogin> getUserLogin(@Query("email")String email, @Query("password")String pass);

    @GET(Constant.PROFILE_UPDATE)
    Call<UpdateData> getProfielupdate(@Query("user_id")String id, @Query("name")String name, @Query("email")String email, @Query("password")String password, @Query("phone")String phone);

    @GET(Constant.USER_PROFILE)
    Call<ForgotPassword> getResetPass(@Query("user_forgot_pass_email")String email);
}
