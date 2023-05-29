package com.example.how2grow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class E_RecyclerViewAdapter extends RecyclerView.Adapter<E_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<ExerciseModel> exerciseModels;

    public E_RecyclerViewAdapter(Context context, ArrayList<ExerciseModel> exerciseModels){
        this.context = context;
        this.exerciseModels = exerciseModels;
    }

    @NonNull
    @Override
    public E_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_row, parent, false);
        return new E_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull E_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(exerciseModels.get(position).getExerciseName());
        holder.tvSetup.setText(exerciseModels.get(position).getExerciseSetup());
        holder.tvExecution.setText(exerciseModels.get(position).getExerciseExecution());
        holder.imageView.setImageResource(exerciseModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return exerciseModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tvSetup, tvExecution;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvSetup = itemView.findViewById(R.id.textView3);
            tvExecution = itemView.findViewById(R.id.textView2);
        }
    }
}
