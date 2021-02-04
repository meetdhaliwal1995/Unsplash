package com.example.ammdhillon;

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
import com.example.ammdhillon.ModelClass.CategoryItem;

import java.util.List;

public class AdapterCategoryMain extends RecyclerView.Adapter<AdapterCategoryMain.ViewHolder> {

    private Context context;
    private List<CategoryItem> _list;

    public AdapterCategoryMain(Context context, List<CategoryItem> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryItem item = _list.get(position);
        Log.e("sss",item.getCategoryImage());
        holder.textView.setText(item.getCategoryName());
        Glide.with(context).load(item.getCategoryImage()).into(holder.imageView);
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
            imageView = itemView.findViewById(R.id.imz_view);
            textView = itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivityChannel.class);
                    intent.putExtra("cat_id",_list.get(getAdapterPosition()).getCid());
                    context.startActivity(intent);
                }
            });
        }
    }
}
