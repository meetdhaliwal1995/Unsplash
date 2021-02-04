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
import com.example.demomeme.ModelCategory.ListCat;

import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    private List<ListCat> _list;
    private Context context;

    public AdapterMain(List<ListCat> _list, Context context) {
        this._list = _list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_meme,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ListCat listCat = _list.get(position);
    holder.textView.setText(listCat.getCategoryName());
        Glide.with(context).load(listCat.getCategoryImage()).into(holder.imageView);
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
                    Intent intent = new Intent(context, ActivityChannel.class);
                    intent.putExtra("singleChannel_id",_list.get(getAdapterPosition()).getCid());
                    intent.putExtra("channel_name",_list.get(getAdapterPosition()).getCategoryName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
