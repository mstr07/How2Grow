package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StatsManagerActivity extends AppCompatActivity {
    RadioGroup radio_group_gender;
    RadioGroup radio_group_goal;
    RadioButton radio_gender;
    RadioButton radio_goal;

    RadioButton radio_male;
    RadioButton radio_female;

    Button button_save;
    Button button_calculate;

    EditText protein;
    EditText fats;
    EditText carbs;
    EditText age;
    EditText weight;
    EditText height;
    TextView kcal;

    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_manager);

        button_save = findViewById(R.id.button_save);
        button_calculate = findViewById(R.id.button_calculate);

        protein = findViewById(R.id.editTextNumber_protein);
        fats = findViewById(R.id.editTextNumber_fats);
        carbs = findViewById(R.id.editTextNumber_carbs);
        age = findViewById(R.id.editTextNumber_age);
        weight = findViewById(R.id.editTextNumber_weight);
        height = findViewById(R.id.editTextNumber_height);
        kcal = findViewById(R.id.Text_kcal);

        radio_group_gender = findViewById(R.id.radio_group_gender);
        radio_group_goal = findViewById(R.id.radio_group_goal);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio_gender = findViewById(radio_group_gender.getCheckedRadioButtonId());
                radio_goal = findViewById(radio_group_goal.getCheckedRadioButtonId());
                double kcal_total;

                if(radio_gender.getText().equals("Mężczyzna")){
                    kcal_total = (10 * Integer.parseInt(weight.getText().toString())) + (6.25 * Integer.parseInt(height.getText().toString())) - (5 * Integer.parseInt(age.getText().toString())) + 5;
                }else{
                    kcal_total = (10 * Integer.parseInt(weight.getText().toString())) + (6.25 * Integer.parseInt(height.getText().toString())) - (5 * Integer.parseInt(age.getText().toString())) - 161;
                }
                if(radio_goal.getText().equals("Masa")){
                    kcal_total += 500;
                }else if(radio_goal.getText().equals("Redukcja")){
                    kcal_total -= 500;
                }
                setup(kcal_total);
            }
        });

        protein.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(protein.getText().toString().matches("")){
                    protein.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!fats.getText().toString().isEmpty() && !carbs.getText().toString().isEmpty()){
                    int prot_int = Integer.parseInt(protein.getText().toString());
                    int fats_int = Integer.parseInt(fats.getText().toString());
                    int carbs_int = Integer.parseInt(carbs.getText().toString());
                    kcal.setText(Long.toString(Math.round(prot_int * 4 + fats_int * 9 + carbs_int * 4)));
                }
                if(protein.getText().toString().matches("")){
                    protein.setText("0");
                }
            }
        });
        fats.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(fats.getText().toString().matches("")){
                    fats.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!protein.getText().toString().isEmpty() && !carbs.getText().toString().isEmpty()){
                    int prot_int = Integer.parseInt(protein.getText().toString());
                    int fats_int = Integer.parseInt(fats.getText().toString());
                    int carbs_int = Integer.parseInt(carbs.getText().toString());
                    kcal.setText(Long.toString(Math.round(prot_int * 4 + fats_int * 9 + carbs_int * 4)));
                }
                if(fats.getText().toString().matches("")){
                    fats.setText("0");
                }
            }
        });
        carbs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(carbs.getText().toString().matches("")){
                    carbs.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!protein.getText().toString().isEmpty() && !fats.getText().toString().isEmpty()){
                    int prot_int = Integer.parseInt(protein.getText().toString());
                    int fats_int = Integer.parseInt(fats.getText().toString());
                    int carbs_int = Integer.parseInt(carbs.getText().toString());
                    kcal.setText(Long.toString(Math.round(prot_int * 4 + fats_int * 9 + carbs_int * 4)));
                }
                if(carbs.getText().toString().matches("")){
                    carbs.setText("0");
                }
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
            }
        });
    }
    public void setup(double kcal_total){
        String weight_str = weight.getText().toString();
        kcal.setText(Long.toString(Math.round(kcal_total)));
        protein.setText(Long.toString(Math.round(Integer.parseInt(weight_str) * 2.2)));
        fats.setText(Long.toString(Math.round(Integer.parseInt(weight_str) * 2.2 * 0.3)));
        String protein_str = protein.getText().toString();
        String fats_str = fats.getText().toString();
        carbs.setText(Long.toString((Math.round(kcal_total - (Double.parseDouble(protein_str) * 4 + Double.parseDouble(fats_str) * 9))/4)));
    }
    public void savePreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("PROTEIN", protein.getText().toString());
        editor.putString("FATS", fats.getText().toString());
        editor.putString("CARBS", carbs.getText().toString());
        editor.putString("KCAL", kcal.getText().toString());

        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}