package com.example.unsplash.views;

import com.example.unsplash.ModelApi.Download.DownloadPic;

public interface DownloadContract {

    interface downloadView {

        void showProgress();

        void hideProgress();

        void setLatestData(DownloadPic downloadPic);
    }

    interface downloadInteracter {

        void getData(String url);
    }
}
