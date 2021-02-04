package com.example.indianmemeammdhillon.Adapters;

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
import com.example.indianmemeammdhillon.ActivitySingleChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelAllChannels.AllChannelList;
import com.example.indianmemeammdhillon.R;

import java.util.List;

public class AdapterAllChanels extends RecyclerView.Adapter<AdapterAllChanels.ViewHolder> {

    private Context context;
    private List<AllChannelList> _list;

    public AdapterAllChanels(Context context, List<AllChannelList> _list) {
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
        AllChannelList list = _list.get(position);

        holder.textView.setText(list.getChannelTitle());
        Glide.with(context).load(list.getChannelThumbnail()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.cat_text);
            imageView = itemView.findViewById(R.id.meme_imz);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivitySingleChannel.class);
                    intent.putExtra("single_detail", _list.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
