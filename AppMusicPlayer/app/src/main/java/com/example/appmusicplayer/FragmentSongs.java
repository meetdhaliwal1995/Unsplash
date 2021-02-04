package com.example.appmusicplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentSongs extends Fragment implements GetUrlInterface {

    RecyclerView recyclerView;
    FragmntSeek fragmntSeek;
    List<PhnSongs> _list = new ArrayList<>();
    AdapterSongs adapterSongs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allsong, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_frag);

//        AdapterSongList adapterSongList = new AdapterSongList(MainActivity._list,getContext(),this);
        adapterSongs = new AdapterSongs(getContext(), MainActivity._list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemViewCacheSize(500);
        recyclerView.setAdapter(adapterSongs);

//        fragmntSeek.setList(_list);
    }

    public void setFragmntSeek(FragmntSeek fragmntSeek) {
        this.fragmntSeek = fragmntSeek;
    }

    @Override
    public void onItemClick(int position) {

        fragmntSeek.songPlay(position);
    }

    @Override
    public void onLongClick(int position) {
        _list.remove(position);
        adapterSongs.notifyItemRemoved(position);
    }

    public void setList(List<PhnSongs> _list) {
        this._list = _list;
    }
}
