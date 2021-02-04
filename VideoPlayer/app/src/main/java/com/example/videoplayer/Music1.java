package com.example.videoplayer;

public class Music1 {

    private String title;
    private String url;
    private String artistName;

    public Music1(String title, String url, String artistName) {
        this.title = title;
        this.url = url;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
