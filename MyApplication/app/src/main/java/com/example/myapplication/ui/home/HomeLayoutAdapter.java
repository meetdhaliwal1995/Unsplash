package com.example.myapplication.ui.home;

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
import com.example.myapplication.R;
import com.example.myapplication.model.category.LIVETV;

import java.util.ArrayList;
import java.util.List;

public class HomeLayoutAdapter extends RecyclerView.Adapter<HomeLayoutAdapter.MYVH>{

    private Context context;
    private List<LIVETV> _list;

    public HomeLayoutAdapter(Context context, List<LIVETV> _list){
        this.context = context;
        this._list = _list;
    }
    @NonNull
    @Override
    public HomeLayoutAdapter.MYVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.home_layout,parent,false);
        return new MYVH(rootView);
    }


    @Override
    public void onBindViewHolder(@NonNull HomeLayoutAdapter.MYVH holder, int position) {
        LIVETV s = _list.get(position);
        Log.e("SSD", s.getCategoryName());
        Glide.with(context).load(s.getCategoryImage()).into(holder.wall);
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class MYVH extends RecyclerView.ViewHolder{

        ImageView wall;

        public MYVH(@NonNull View itemView) {
            super(itemView);
            wall = itemView.findViewById(R.id.imageview_wall);
        }
    }
}