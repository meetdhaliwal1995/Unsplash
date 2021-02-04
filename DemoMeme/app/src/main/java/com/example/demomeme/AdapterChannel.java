package com.example.demomeme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demomeme.ModelChannel.ListChannel;

import java.util.List;

public class AdapterChannel extends RecyclerView.Adapter<AdapterChannel.ViewHolder> {
    private Context context;
    private List<ListChannel> _list;

    public AdapterChannel(Context context, List<ListChannel> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_meme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListChannel list = _list.get(position);
        Glide.with(context).load(list.getChannelThumbnail()).into(holder.imageView);
        holder.textView.setText(list.getChannelTitle());


    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.meme_imz);
            textView = itemView.findViewById(R.id.cat_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ActivitySingelChannel.class);
                    intent.putExtra("single_image",_list.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });

        }
    }
}
