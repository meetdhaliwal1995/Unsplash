package com.example.adapterpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.ViewHolder>{

    private Context context;
    private List<MyPhnContacts> _list;

    public AdapterContacts(Context context, List _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyPhnContacts phnContcts = _list.get(position);
        holder.contact1.setText(phnContcts.getName());
        holder.contact2.setText(phnContcts.getNumber());


    }

    @Override
    public int getItemCount() {

        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView contact1,contact2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contact1 = itemView.findViewById(R.id.contacts);
            contact2 = itemView.findViewById(R.id.contacts2);

        }
    }

}
