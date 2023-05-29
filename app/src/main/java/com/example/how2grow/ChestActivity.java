package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ChestActivity extends AppCompatActivity {

    ArrayList<ExerciseModel> exerciseModels = new ArrayList<>();
    int[] exerciseImages = {R.drawable.barbell_bench_press, R.drawable.incline_dumbbell_bench_press, R.drawable.cable_cross_over
    , R.drawable.chest_dip, R.drawable.push_up_tall};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        RecyclerView recyclerView = findViewById(R.id.chest_recycle_view);

        setUpExerciseModels();

        E_RecyclerViewAdapter adapter = new E_RecyclerViewAdapter(this, exerciseModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpExerciseModels(){
        String[] exerciseNames = getResources().getStringArray(R.array.chest_exercises_names);
        String[] exerciseSetups = getResources().getStringArray(R.array.chest_exercises_setup);
        String[] exerciseExecutions = getResources().getStringArray(R.array.chest_exercises_execution);

        for(int i = 0; i < exerciseNames.length; i++){
            exerciseModels.add(new ExerciseModel(exerciseNames[i], exerciseSetups[i], exerciseExecutions[i], exerciseImages[i]));
        }
    }
}