package com.example.ammdhillon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ammdhillon.ModelChannel.LIVETV;

import java.util.List;

public class AdapterChannel extends RecyclerView.Adapter<AdapterChannel.ViewHolder> {


    private Context context;
    private List<LIVETV> _list;

    public AdapterChannel(Context context, List<LIVETV> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LIVETV livetv = _list.get(position);
        Glide.with(context).load(livetv.getChannelThumbnail()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imz_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivitySingleChannel.class);
                    intent.putExtra("single_channel",_list.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
