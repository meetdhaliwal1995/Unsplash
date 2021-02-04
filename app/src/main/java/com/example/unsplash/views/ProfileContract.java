package com.example.unsplash.views;

import com.example.unsplash.ModelApi.UserProfile.Photo;
import com.example.unsplash.ModelApi.UserProfile.UserProfile;

import java.util.List;

public interface ProfileContract {

    interface profileView {

        void showProgress();

        void hideProgress();

        void setLatestData(UserProfile userProfile);


    }

    interface profileInteracter {
        void getData(String username);
    }

}
