package com.example.unsplash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplash.ModelApi.UserData.UserPhoto;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private Context context;
    private List<UserPhoto> _list;
    private AdapterInterface adapterInterface;
    private long lastTouchTime = 0;
    private long currentTouchTime = 0;
    boolean clicked = false;
    boolean check = true;

    public AdapterUser(Context context, List<UserPhoto> _list, AdapterInterface adapterInterface) {
        this.context = context;
        this._list = _list;
        this.adapterInterface = adapterInterface;
    }

    interface AdapterInterface {

        void onClick();

        void onPageBottom();
    }

    @NonNull
    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterUser.ViewHolder holder, int position) {
        UserPhoto list = _list.get(position);
        Glide.with(context).load(list.getUrls().getRegular()).into(holder.imageView);

        if (getItemCount() == _list.size() + 1) {
            if (adapterInterface != null) {
                Log.e("SD", "SS");
                adapterInterface.onPageBottom();
            }
        }
    }

    public void set_list(List<UserPhoto> _list) {
        this._list.addAll(_list);
        notifyItemInserted(_list.size());
    }

    @Override
    public int getItemCount() {

        return _list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView btnlike, like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.image_one);

            btnlike = itemView.findViewById(R.id.like_btn);
            like = itemView.findViewById(R.id.image_like);
            btnlike.setVisibility(View.VISIBLE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("UseCompatLoadingForDrawables")
                @Override
                public void onClick(View v) {

                    lastTouchTime = currentTouchTime;
                    currentTouchTime = System.currentTimeMillis();

                    if (currentTouchTime - lastTouchTime < 250) {
                        btnlike.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_favorite_fill));
                        Log.d("Duble", "Click");
                        clicked = true;
                        lastTouchTime = 0;
                        currentTouchTime = 0;


                    }
                }
            });

            btnlike.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("UseCompatLoadingForDrawables")
                @Override
                public void onClick(View v) {
                    Log.e("Click","btn");

                    Drawable drawable = btnlike.getDrawable();
                    @SuppressLint("UseCompatLoadingForDrawables")
                    Drawable drawable1 = context.getDrawable(R.drawable.ic_baseline_favorite_fill);
                    if (drawable == drawable1) {
                        Log.e("aaa","ggg");
                        btnlike.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_favorite_notfill));
                    } else {
                        btnlike.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_favorite_fill));
                        Log.e("aaa","bbb");
                    }
                }
            });
        }
    }
}