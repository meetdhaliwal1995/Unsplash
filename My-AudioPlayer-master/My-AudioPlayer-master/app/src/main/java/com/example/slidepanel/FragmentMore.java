package com.example.slidepanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentMore extends DialogFragment {

    TextView play, share, playlist, queue, edit, dlte;
    MainActivity mainActivity;
    private List<PhnSongs> _list = new ArrayList<>();
    private GetUrlInterface callback;
    private int pos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        play = view.findViewById(R.id.text_play);
        share = view.findViewById(R.id.text_send);
        playlist = view.findViewById(R.id.text_playlist);
        queue = view.findViewById(R.id.text_queue);
        edit = view.findViewById(R.id.text_edit);
        dlte = view.findViewById(R.id.text_delete);

        mainActivity = (MainActivity) getActivity();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(pos);
            }
        });

        dlte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onLongClick(pos);
                Toast.makeText(getContext(),"song dlte",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setGetUrlInterface(GetUrlInterface getUrlInterface, int pos) {
        this.callback = getUrlInterface;
        this.pos = pos;
    }

    public void set_list(List<PhnSongs> _list) {
        this._list = _list;
    }


}
