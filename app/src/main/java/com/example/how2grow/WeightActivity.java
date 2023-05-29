package com.example.how2grow;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeightActivity extends AppCompatActivity {
    EditText date, weight;
    Button submit;
    ManageData manageData;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        submit = findViewById(R.id.button_save_weight);
        date = findViewById(R.id.editTextDate);
        weight = findViewById(R.id.editTextNumber);
        manageData = new ManageData(this);
        listView = (ListView)findViewById(R.id.listView);
        showData(manageData.selectAll());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageData.insert(date.getText().toString(), Double.parseDouble(weight.getText().toString()));
                showData(manageData.selectAll());
            }
        });
    }
    public void showData(Cursor c){
        while (c.moveToNext()){
            ArrayList<String> arrayList = new ArrayList<>();

            String line = "";
            while(c.moveToNext())
            {
                line = c.getString(1) + "                                                  " + c.getString(2) + " kg";
                //Log.i(c.getString(1), String.valueOf(c.getDouble(2)));
                arrayList.add(line);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
            line = "";
            //Log.i(c.getString(1), String.valueOf(c.getDouble(2)));
        }
    }
}