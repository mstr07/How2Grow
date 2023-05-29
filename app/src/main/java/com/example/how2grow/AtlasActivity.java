package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AtlasActivity extends AppCompatActivity {

    Button klatka,biceps,triceps,plecy,barki,brzuch,quad,ham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atlas);
        Log.i("tag","tag");
        klatka = findViewById(R.id.button_chest);
        klatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, ChestActivity.class);
                startActivity(intent);
            }
        });
        plecy = findViewById(R.id.button_back);
        plecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, BackActivity.class);
                startActivity(intent);
            }
        });
        barki = findViewById(R.id.button_delts);
        barki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, ShouldersActivity.class);
                startActivity(intent);
            }
        });
        biceps = findViewById(R.id.button_biceps);
        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, BicepsActivity.class);
                startActivity(intent);
            }
        });
        triceps = findViewById(R.id.button_triceps);
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, TricepsActivity.class);
                startActivity(intent);
            }
        });
        quad = findViewById(R.id.button_quad);
        quad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, QuadsActivity.class);
                startActivity(intent);
            }
        });
        ham = findViewById(R.id.button_ham);
        ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, HamsActivity.class);
                startActivity(intent);
            }
        });
        brzuch = findViewById(R.id.button_brzuch);
        brzuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtlasActivity.this, AbsActivity.class);
                startActivity(intent);
            }
        });
    }
}