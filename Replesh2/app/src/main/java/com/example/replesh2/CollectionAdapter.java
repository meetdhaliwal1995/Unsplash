package com.example.replesh2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.replesh2.Video.LIVETV3;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {

    private Context context;
    private List<LIVETV3> _list;

    public CollectionAdapter(Context context, List<LIVETV3> _list) {
        this._list = _list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.collection_layout, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LIVETV3 s = _list.get(position);
        Log.e("aaa", s.getCategoryName());
        Glide.with(context).load(s.getCategoryImage()).into(holder.wallpaper);
        holder.textView.setText(s.getCategoryName());
    }

    @Override
    public int getItemCount() {

        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wallpaper;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wallpaper = itemView.findViewById(R.id.imageview_wallpaper2);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
