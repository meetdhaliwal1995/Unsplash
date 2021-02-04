package com.example.slidepanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterSongs extends RecyclerView.Adapter<AdapterSongs.ViewHolder> {

    private Context context;
    private List<PhnSongs> _list;
    //    private SongClass songClass;
    private GetUrlInterface anInterface;
    private List<PhnSongs> _listAllSong;


    public AdapterSongs(Context context, List<PhnSongs> _list, GetUrlInterface anInterface) {
//        songClass = new SongClass();
        this.context = context;
        this._list = _list;
        this.anInterface = anInterface;
        this._listAllSong = new ArrayList<>(_list);
    }
//this.interface

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhnSongs phnSongs = _list.get(position);

        holder.songName.setText(phnSongs.getTitle());
        holder.artistName.setText(phnSongs.getArtist());
//        Glide.with(context).load(phnSongs.getAlbumArt()).into(holder.albumArt);
        GitMapClass gitMapClass = new GitMapClass(context, phnSongs.getUri(), holder, position);
        gitMapClass.execute();


    }

    @Override
    public int getItemCount() {

        return _list.size();
    }

    public void refreshData(List<PhnSongs> tempList) {
        this._list = tempList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        public Notification.WearableExtender constraintLayout;
        TextView songName, artistName;
        ImageView albumArt, more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            artistName = itemView.findViewById(R.id.song_name1);
            albumArt = itemView.findViewById(R.id.album_art);
            more = itemView.findViewById(R.id.more_);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    songClass.stop();
//                    songClass.song(context, _list.get(getAdapterPosition()).getUri());
//                    Log.e("sss","ffff");
                    anInterface.onItemClick(getAdapterPosition());

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    anInterface.onLongClick(getAdapterPosition());
                    return true;
                }
            });

            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) context;
//                  call main activity bcoz i want get support manager;

                    FragmentMore fragmentMore = new FragmentMore();
                    fragmentMore.setGetUrlInterface(anInterface, getAdapterPosition());
                    activity.getSupportFragmentManager().beginTransaction()
                            .add(android.R.id.content, fragmentMore)
                            .addToBackStack(fragmentMore.getTag())
                            .commit();
                }
            });
        }

    }
}
