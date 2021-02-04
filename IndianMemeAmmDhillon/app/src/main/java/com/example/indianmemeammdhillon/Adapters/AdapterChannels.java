package com.example.indianmemeammdhillon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.indianmemeammdhillon.ActivitySingleChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelChannel.ListChannel;
import com.example.indianmemeammdhillon.R;

import java.util.List;

public class AdapterChannels extends RecyclerView.Adapter<AdapterChannels.ViewHolder> {

    private Context context;
    private List<ListChannel> _list;

    public AdapterChannels(Context context, List<ListChannel> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_channeladapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListChannel list = _list.get(position);
        Log.e("sss",list.getCategoryImage());
        Glide.with(context).load(list.getChannelThumbnail()).into(holder.channelimage);

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView channelimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            channelimage = itemView.findViewById(R.id.channel_imz);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivitySingleChannel.class);
                    intent.putExtra("single_detail",_list.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
