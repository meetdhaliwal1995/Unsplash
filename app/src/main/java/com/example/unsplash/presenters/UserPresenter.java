package com.example.unsplash.presenters;

import com.example.unsplash.Constant;
import com.example.unsplash.ModelApi.UserData.UserPhoto;
import com.example.unsplash.MyApp;
import com.example.unsplash.NetworkInterface;
import com.example.unsplash.views.UserContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements UserContract.userInteractor {

    private UserContract.userView userView;

    public UserPresenter(UserContract.userView userView) {
        this.userView = userView;
    }


    @Override
    public void getData(String username, String page) {
        userView.showProgress();
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getUserInfo(username, page, Constant.ACCESS_KEY).enqueue(new Callback<List<UserPhoto>>() {
            @Override
            public void onResponse(Call<List<UserPhoto>> call, Response<List<UserPhoto>> response) {
                userView.setLatestData(response.body());
                userView.hideProgress();
            }

            @Override
            public void onFailure(Call<List<UserPhoto>> call, Throwable t) {
                userView.hideProgress();
            }
        });
    }
}

