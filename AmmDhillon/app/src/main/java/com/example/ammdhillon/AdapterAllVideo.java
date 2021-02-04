package com.example.ammdhillon;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devbrackets.android.exomedia.core.exoplayer.ExoMediaPlayer;
import com.example.ammdhillon.AllVideos.LIVETV;

import java.util.List;

public class AdapterAllVideo extends RecyclerView.Adapter<AdapterAllVideo.ViewHolder> {

    private Context context;
    private List<LIVETV> _list;

    public AdapterAllVideo(Context context, List<LIVETV> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LIVETV livetv = _list.get(position);
        Glide.with(context).load(livetv.getVideoThumbnailB()).into(holder.imageView);
        holder.textView.setText(livetv.getVideoTitle());


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
            imageView = itemView.findViewById(R.id.imz_view);
            textView = itemView.findViewById(R.id.text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("sss","gggg");
                    Intent intent = new Intent(context,ActivityPlayVideo.class);
                    intent.putExtra("video_url",_list.get(getAdapterPosition()).getVideoUrl());
                    context.startActivity(intent);
                }
            });
        }
    }
}
