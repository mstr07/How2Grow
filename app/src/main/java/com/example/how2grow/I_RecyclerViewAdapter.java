package com.example.how2grow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class I_RecyclerViewAdapter extends RecyclerView.Adapter<I_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> info;

    public I_RecyclerViewAdapter(Context context, ArrayList<String> info){
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public I_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.info_row, parent, false);
        return new I_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull I_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvInfo.setText(info.get(position));
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvInfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvInfo = itemView.findViewById(R.id.tvInfo);
        }
    }
}
