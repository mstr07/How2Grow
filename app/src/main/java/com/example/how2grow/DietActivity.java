package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity {
    ArrayList<String> principles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        RecyclerView recyclerView = findViewById(R.id.diet_recycler_view);
        SetupPrinciples();
        I_RecyclerViewAdapter adapter = new I_RecyclerViewAdapter(this, principles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void SetupPrinciples(){
        String[] nutrition_basics = getResources().getStringArray(R.array.nutrition_basics);
        for(int i = 0; i < nutrition_basics.length; i++){
            principles.add(nutrition_basics[i]);
        }
    }
}