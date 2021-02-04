package com.example.indianmemeammdhillon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.indianmemeammdhillon.ActivityChannels;
import com.example.indianmemeammdhillon.ModelApi.ModelCategory.ListCategory;
import com.example.indianmemeammdhillon.R;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    private Context context;
    private List<ListCategory> _list;

    public AdapterCategory(Context context, List<ListCategory> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_meme,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListCategory list = _list.get(position);
        Log.e("sss",list.getCategoryImage());
        Glide.with(context).load(list.getCategoryImage()).into(holder.memeImage);
        holder.textView.setText(list.getCategoryName());

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView memeImage;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            memeImage = itemView.findViewById(R.id.meme_imz);
            textView = itemView.findViewById(R.id.cat_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivityChannels.class);
                    intent.putExtra("cat_id",_list.get(getAdapterPosition()).getCid());
                    intent.putExtra("cat_name",_list.get(getAdapterPosition()).getCategoryName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
