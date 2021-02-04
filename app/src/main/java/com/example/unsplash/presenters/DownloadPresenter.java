package com.example.unsplash.presenters;

import com.example.unsplash.Constant;
import com.example.unsplash.ModelApi.Download.DownloadPic;
import com.example.unsplash.MyApp;
import com.example.unsplash.NetworkInterface;
import com.example.unsplash.views.DownloadContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadPresenter implements DownloadContract.downloadInteracter {

    private DownloadContract.downloadView downloadView;

    public DownloadPresenter(DownloadContract.downloadView downloadView) {
        this.downloadView = downloadView;
    }

    @Override
    public void getData(String url) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getDownload(url, Constant.ACCESS_KEY).enqueue(new Callback<DownloadPic>() {
            @Override
            public void onResponse(Call<DownloadPic> call, Response<DownloadPic> response) {
                downloadView.setLatestData(response.body());
            }

            @Override
            public void onFailure(Call<DownloadPic> call, Throwable t) {

            }
        });

    }
}
