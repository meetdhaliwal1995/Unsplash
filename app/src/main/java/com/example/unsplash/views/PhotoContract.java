package com.example.unsplash.views;

import android.net.LinkAddress;

import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.example.unsplash.ModelApi.AllPhotos.Links;

import java.util.List;

public interface PhotoContract {

    interface photoView {

        void showProgress();

        void hideProgress();

        void setLatestData(List<AllPhoto> allPhoto);
    }

    interface photoInteractor {

        void getData(String page);
    }
}
