package com.example.recycleviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private ArrayList<DetailList> _list;
    private Context context;

    public AdapterClass(ArrayList<DetailList> _list, Context context) {
        this._list = _list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.detail_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailList ggg = _list.get(position);

        holder.textView.setText(ggg.getAdd());
        holder.textView2.setText(ggg.getHome());
//        String s = String.valueOf(ggg.getNumber());
        holder.textView3.setText(String.valueOf(ggg.getNumber()));

    }

    @Override
    public int getItemCount() {

        return _list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2,textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.recycle_text);
            textView2 = itemView.findViewById(R.id.recycle_text2);
            textView3 = itemView.findViewById(R.id.recycle_text3);

        }
    }
}
