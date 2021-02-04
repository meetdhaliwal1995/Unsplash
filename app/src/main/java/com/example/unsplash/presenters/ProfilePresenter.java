package com.example.unsplash.presenters;

import com.example.unsplash.Constant;
import com.example.unsplash.ModelApi.UserProfile.UserProfile;
import com.example.unsplash.MyApp;
import com.example.unsplash.NetworkInterface;
import com.example.unsplash.views.ProfileContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter implements ProfileContract.profileInteracter {

    ProfileContract.profileView profileView;

    public ProfilePresenter(ProfileContract.profileView profileView) {
        this.profileView = profileView;
    }


    @Override
    public void getData(String username) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getUserProfile(username, Constant.ACCESS_KEY).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                profileView.setLatestData(response.body());
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }
}
