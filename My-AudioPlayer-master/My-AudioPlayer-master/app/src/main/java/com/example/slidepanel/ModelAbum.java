package com.example.slidepanel;

import java.util.List;

public class ModelAbum {

    private String album;
    private List<PhnSongs> _list;

    public ModelAbum() {
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<PhnSongs> get_list() {
        return _list;
    }

    public void set_list(List<PhnSongs> _list) {

        this._list = _list;
    }
}

