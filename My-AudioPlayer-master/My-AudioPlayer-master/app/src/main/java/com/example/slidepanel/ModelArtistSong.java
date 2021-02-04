package com.example.slidepanel;

import java.util.List;

public class ModelArtistSong extends PhnSongs {

    private String artistName;
    private List<PhnSongs> _list;
    private String url;

    public ModelArtistSong(){

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtist() {

        return artistName;
    }

    public void setArtist(String artist)
    {
        this.artistName = artist;
    }

    public List<PhnSongs> get_list()

    {
        return _list;
    }

    public void set_list(List<PhnSongs> _list)
    {

        this._list = _list;
    }
}
