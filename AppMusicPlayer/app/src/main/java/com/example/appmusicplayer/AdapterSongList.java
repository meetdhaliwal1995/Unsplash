package com.example.appmusicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSongList extends RecyclerView.Adapter<AdapterSongList.ViewHolder> {

    private List<PhnSongs> _list;
    private Context context;
    private GetUrlInterface getUrlInterface;

    public AdapterSongList(List<PhnSongs> _list, Context context,GetUrlInterface getUrlInterface) {
        this._list = _list;
        this.context = context;
        this.getUrlInterface = getUrlInterface;
    }

    @NonNull
    @Override
    public AdapterSongList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSongList.ViewHolder holder, int position) {
        PhnSongs list = _list.get(position);
        holder.song.setText(list.getTitle());
        holder.artist.setText(list.getArtist());

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView song, artist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            song = itemView.findViewById(R.id.song_name);
            artist = itemView.findViewById(R.id.song_name1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getUrlInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
