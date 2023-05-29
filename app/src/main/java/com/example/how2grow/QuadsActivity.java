package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class QuadsActivity extends AppCompatActivity {

    ArrayList<ExerciseModel> exerciseModels = new ArrayList<>();
    int[] exerciseImages = {R.drawable.squat, R.drawable.bulgarian_split_squat, R.drawable.leg_extensions};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads);

        RecyclerView recyclerView = findViewById(R.id.quads_recycle_view);

        setUpExerciseModels();

        E_RecyclerViewAdapter adapter = new E_RecyclerViewAdapter(this, exerciseModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpExerciseModels(){
        String[] exerciseNames = getResources().getStringArray(R.array.quads_exercises_names);
        String[] exerciseSetups = getResources().getStringArray(R.array.quads_exercises_setup);
        String[] exerciseExecutions = getResources().getStringArray(R.array.quads_exercises_execution);

        for(int i = 0; i < exerciseNames.length; i++){
            exerciseModels.add(new ExerciseModel(exerciseNames[i], exerciseSetups[i], exerciseExecutions[i], exerciseImages[i]));
        }
    }
}