package com.example.adaptercreateowndata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    private Context context;
    private List<DetailList> _list;

    public AdapterRecycler(Context context, List<DetailList> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailList detailList = _list.get(position);

        holder.textView1.setText(detailList.getName());
        holder.textView2.setText(detailList.getAdd());
        holder.textView3.setText(String.valueOf(detailList.getNumber()));

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1,textView2,textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2= itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);
        }
    }
}
