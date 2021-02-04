package com.example.replesh2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.replesh2.model.LIVETV2;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private Context context;
    private List<LIVETV2> _list;

    public PhotosAdapter(Context context, List<LIVETV2> _list) {
        this._list = _list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.photos_layout, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        LIVETV2 s = _list.get(position);
        Log.e("ssds = " + position, s.getChannelTitle());
//        holder.textView.setText(s.getCategoryName());
        Glide.with(context).load(s.getChannelThumbnail()).into(holder.wallpaper);
    }

    @Override
    public int getItemCount() {

        return _list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wallpaper;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wallpaper = itemView.findViewById(R.id.photos_wallpaper);
        }
    }
}
