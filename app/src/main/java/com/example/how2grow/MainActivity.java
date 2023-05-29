package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int intLayout = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    TextView protein_value, fats_value, carbs_value, kcal_value;
    String protein, fats, carbs, kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button stats_manager_button = findViewById(R.id.edit_stats_button);
        Button button_atlas = findViewById(R.id.button_atlas);
        Button training = findViewById(R.id.button_training);
        Button diet = findViewById(R.id.button_diet);
        Button weight = findViewById(R.id.button_weight);
        protein_value = findViewById(R.id.protein_value);
        fats_value = findViewById(R.id.fats_value);
        carbs_value = findViewById(R.id.carbs_value);
        kcal_value = findViewById(R.id.kcal_value);

        stats_manager_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout = 2;
                Intent intent = new Intent(MainActivity.this, StatsManagerActivity.class);
                startActivity(intent);
            }
        });
        button_atlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout = 3;
                Intent intent = new Intent(MainActivity.this, AtlasActivity.class);
                startActivity(intent);
            }
        });
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout = 4;
                Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout = 5;
                Intent intent = new Intent(MainActivity.this, DietActivity.class);
                startActivity(intent);
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout = 6;
                Intent intent = new Intent(MainActivity.this, WeightActivity.class);
                startActivity(intent);
            }
        });
        loadData();
        updateData();

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        protein =  sharedPreferences.getString("PROTEIN", "");
        fats =  sharedPreferences.getString("FATS", "");
        carbs =  sharedPreferences.getString("CARBS", "");
        kcal =  sharedPreferences.getString("KCAL", "");

    }

    public void updateData(){
        protein_value.setText(protein);
        fats_value.setText(fats);
        carbs_value.setText(carbs);
        kcal_value.setText(kcal);
    }

    public void refresh(){
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed(){
        if(intLayout == 2 || intLayout == 3 || intLayout == 4 || intLayout == 5 || intLayout == 6){
            intLayout = 1;
            loadData();
            updateData();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            super.onBackPressed();
        }

    }
}