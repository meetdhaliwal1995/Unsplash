package com.example.videoplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder>{


    private Context context;
    private ArrayList<Music1> _list;

    public AdapterRecycler(Context context, int song_list, ArrayList<Music1> _list){
        this._list = _list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.song_list,parent,false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Music1 arrayList = _list.get(position);

        holder.song2.setText(arrayList.getTitle());
        holder.song1.setText(arrayList.getArtistName());

       holder.song1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.setAction(_list.get(position).getUrl());
                context.startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount()
    {

        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView song1,song2;
        String url;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_image);
            song1 = itemView.findViewById(R.id.song_1);
            song2 = itemView.findViewById(R.id.song_2);

        }
    }
}


