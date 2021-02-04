package com.example.coronavirusapi.presenters;

import com.example.coronavirusapi.MyApp;
import com.example.coronavirusapi.NetworkInterface;
import com.example.coronavirusapi.views.DateContract;

import ModelApi.LatestDate.RegionDate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatePresenter implements DateContract.DateInteractor {

    private DateContract.DateView dateView;

    public DatePresenter(DateContract.DateView dateView) {
        this.dateView = dateView;
    }

    @Override
    public void getData(String regionName) {
        dateView.showProgress();
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getRegion(regionName).enqueue(new Callback<RegionDate>() {
            @Override
            public void onResponse(Call<RegionDate> call, Response<RegionDate> response) {
                dateView.setLatestDate(response.body());
                dateView.hideProgress();
            }
            @Override
            public void onFailure(Call<RegionDate> call, Throwable t) {
                dateView.hideProgress();
            }
        });
    }
}
