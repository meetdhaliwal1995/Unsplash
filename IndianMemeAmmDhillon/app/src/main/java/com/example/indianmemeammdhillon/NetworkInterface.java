package com.example.indianmemeammdhillon;

import com.example.indianmemeammdhillon.ModelApi.ModelAllChannels.AllChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelAppDetail.AppDetail;
import com.example.indianmemeammdhillon.ModelApi.ModelCategory.MemeCategory;
import com.example.indianmemeammdhillon.ModelApi.ModelChannel.MemeChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelForgotData.ResetData;
import com.example.indianmemeammdhillon.ModelApi.ModelLogin.UserLogin;
import com.example.indianmemeammdhillon.ModelApi.ModelRegisterUser.RegisterUser;
import com.example.indianmemeammdhillon.ModelApi.ModelSingleChannel.SingleChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelUpdateProfile.UpdateData;
import com.example.indianmemeammdhillon.ModelApi.ModelUserProfile.UserProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetworkInterface {


    @Headers(value = "access_token")

    @GET(Constant.MEME_CATEGORY)
    Call<MemeCategory> getMemeCategory();

    @GET(Constant.MEME_CHANNEL)
    Call<MemeChannel> getMemeChannel(@Query("get_channels_by_cat_id") String id);

    @GET(Constant.MEME_CHANNEL)
    Call<SingleChannel> getSingleChannel(@Query("get_single_channel_id") String id);

    @GET(Constant.MEME_CHANNEL)
    Call<MemeChannel> getSearchChannel(@Query("get_search_channels") String id);

    @GET(Constant.MEME_CHANNEL)
    Call<AppDetail> getAppDetail();

    @GET(Constant.All_CHANNEL)
    Call<AllChannel> getAllChannesl();

    @POST(Constant.LOGIN)
    Call<UserLogin> userLogin(@Query("email") String email, @Query("password") String password);

    @GET(Constant.USER_PROFILE)
    Call<UserProfile> userProfile(@Query("get_user_profile")String id);

    @GET(Constant.USER_PROFILE)
    Call<ResetData> resetData(@Query("user_forgot_pass_email") String email);

    @GET(Constant.USER_UPDATE)
    Call<UpdateData> userUpdate(@Query("user_id") String id ,@Query("name") String name, @Query("phone") String phone,@Query("email") String email,@Query("password") String password);

    @GET(Constant.USER_REGISTER)
    Call<RegisterUser> getUserRegister(@Query("name")String name,@Query("email")String email,@Query("password")String pass,@Query("phone")String phone);
}
