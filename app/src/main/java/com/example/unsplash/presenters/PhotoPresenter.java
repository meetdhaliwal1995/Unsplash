package com.example.unsplash.presenters;

import com.example.unsplash.Constant;
import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.example.unsplash.MyApp;
import com.example.unsplash.NetworkInterface;
import com.example.unsplash.views.PhotoContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoPresenter implements PhotoContract.photoInteractor {

    private PhotoContract.photoView photoView;

    public PhotoPresenter(PhotoContract.photoView photoView) {
        this.photoView = photoView;
    }


    @Override
    public void getData(final String page) {
        photoView.showProgress();
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getAllPhotos(page, Constant.ACCESS_KEY).enqueue(new Callback<List<AllPhoto>>() {
            @Override
            public void onResponse(Call<List<AllPhoto>> call, Response<List<AllPhoto>> response) {
                photoView.setLatestData(response.body());
                photoView.hideProgress();
            }

            @Override
            public void onFailure(Call<List<AllPhoto>> call, Throwable t) {
                photoView.hideProgress();

            }
        });
    }
}
