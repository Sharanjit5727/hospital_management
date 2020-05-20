package com.example.hospitalcse226;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class appointment extends AppCompatActivity  {
    EditText etname, etmob,etemail;
    Button butsave;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        etname = findViewById(R.id.et11);
        etmob = findViewById(R.id.et12);
        etemail = findViewById(R.id.et13);

        butsave = findViewById(R.id.but11);

        spinner = (Spinner) findViewById(R.id.spin1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // clicked item will be shown as spinner
                Toast.makeText(getApplicationContext(), " " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database_appoint md = new database_appoint(getApplicationContext());
                md.insertValues(etname.getText().toString(),Long.parseLong(etmob.getText().toString()), etemail.getText().toString());


                finish();
            }
        });

    }


}
