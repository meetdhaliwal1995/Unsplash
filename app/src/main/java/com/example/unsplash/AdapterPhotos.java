package com.example.unsplash;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;

import java.util.List;

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolder> {

    private Context context;
    private List<AllPhoto> _list;
    private InterfaceContent interfaceContent;


    public AdapterPhotos(Context context, List<AllPhoto> _list, InterfaceContent interfaceContent) {
        this.context = context;
        this._list = _list;
        this.interfaceContent = interfaceContent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        AllPhoto list = _list.get(position);
        Glide.with(context).load(list.getUrls().getRegular()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_one);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (interfaceContent != null) {
                        interfaceContent.callBack(_list.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
