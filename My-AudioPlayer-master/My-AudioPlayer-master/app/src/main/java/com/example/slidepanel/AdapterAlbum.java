package com.example.slidepanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.ViewHolder> {

    private Context context;
    private List<ModelAbum> _listAlbum;

    public AdapterAlbum(Context context, List<ModelAbum> _listAlbum) {
        this.context = context;
        this._listAlbum = _listAlbum;
    }

    @NonNull
    @Override
    public AdapterAlbum.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_layout_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelAbum modelAbum = _listAlbum.get(position);
        holder.name.setText(String.valueOf(modelAbum.get_list().size()));
        holder.artistName.setText(modelAbum.getAlbum());
        Glide.with(context).load(R.drawable.musicimg).into(holder.albumAr);

    }

    @Override
    public int getItemCount() {
        return _listAlbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView artistName, name;
        ImageView albumAr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistName = itemView.findViewById(R.id.song_name);
            name = itemView.findViewById(R.id.song_name1);
            albumAr = itemView.findViewById(R.id.album_art);
        }
    }
}
