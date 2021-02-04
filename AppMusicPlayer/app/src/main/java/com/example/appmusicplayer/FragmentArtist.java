package com.example.appmusicplayer;

import android.os.Bundle;
import android.util.Log;
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

public class FragmentArtist extends Fragment {

    RecyclerView recyclerView;
    AdapterArtistSong adapterArtist;
    public List<ModelArtistSong> _listArt = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_frag2);
        Log.e("ddd", String.valueOf(_listArt.size()));

        adapterArtist = new AdapterArtistSong(getContext(), _listArt);
        Log.e("aaaa", String.valueOf(_listArt.size()));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapterArtist);


    }


    public void setList(List<ModelArtistSong> _listArtist) {
        this._listArt = _listArtist;
        Log.e("artist", String.valueOf(_listArtist.size()));
    }
}

