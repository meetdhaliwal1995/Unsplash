package com.example.slidepanel;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentSongs extends Fragment implements GetUrlInterface {
    RecyclerView recyclerView;
    AdapterSongs adapterSongs;
    public List<PhnSongs> _list;
    SongClass songClass;
    private MainActivity getMainActivity;
    FragmentMore fragmentMore;
    public static String query;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allsong, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_frag);

        getMainActivity = (MainActivity) getActivity();

        adapterSongs = new AdapterSongs(getContext(), _list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemViewCacheSize(500);
        recyclerView.setAdapter(adapterSongs);

        songClass = new SongClass();
//        getMainActivity.setAdapterSongs(adapterSongs);

    }

//    public void setFragmentMore(FragmentMore fragmentMore) {
//        this.fragmentMore = fragmentMore;
//    }

    @Override
    public void onItemClick(int position) {
        getMainActivity.songPlay(position);
    }

    @Override
    public void onLongClick(int position) {
        _list.remove(position);
        adapterSongs.notifyItemRemoved(position);

    }

    public void set_list(List<PhnSongs> _list) {
        this._list = _list;
        Log.e("song", String.valueOf(_list.size()));
    }

    public void setString(String str) {
        List<PhnSongs> _tempList = new ArrayList<>();

        if (!str.equalsIgnoreCase("")) {
            for (PhnSongs song : _list) {
                if (song.getTitle().toLowerCase().contains(str.toLowerCase())) {
                    _tempList.add(song);
                }
            }
        } else {
            _tempList = _list;
        }

        adapterSongs.refreshData(_tempList);

    }
}


