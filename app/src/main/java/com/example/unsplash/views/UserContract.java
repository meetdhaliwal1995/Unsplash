package com.example.unsplash.views;

import com.example.unsplash.ModelApi.UserData.UserPhoto;

import java.util.List;

public interface UserContract {

    interface userView {

        void showProgress();

        void hideProgress();

        void setLatestData(List<UserPhoto> userPhotos);
    }

    interface userInteractor {

        void getData(String page, String name);
    }
}
