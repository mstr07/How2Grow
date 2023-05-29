package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BicepsActivity extends AppCompatActivity {

    ArrayList<ExerciseModel> exerciseModels = new ArrayList<>();
    int[] exerciseImages = {R.drawable.dumbbell_curl, R.drawable.dumbbell_incline_curl, R.drawable.preacher_curl};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        RecyclerView recyclerView = findViewById(R.id.biceps_recycle_view);

        setUpExerciseModels();

        E_RecyclerViewAdapter adapter = new E_RecyclerViewAdapter(this, exerciseModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpExerciseModels(){
        String[] exerciseNames = getResources().getStringArray(R.array.biceps_exercises_names);
        String[] exerciseSetups = getResources().getStringArray(R.array.biceps_exercises_setup);
        String[] exerciseExecutions = getResources().getStringArray(R.array.biceps_exercises_execution);

        for(int i = 0; i < exerciseNames.length; i++){
            exerciseModels.add(new ExerciseModel(exerciseNames[i], exerciseSetups[i], exerciseExecutions[i], exerciseImages[i]));
        }
    }
}