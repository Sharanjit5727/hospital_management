package com.example.hospitalcse226;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class view_apppoint extends AppCompatActivity {
    ListView lvsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apppoint);
        lvsearch = findViewById(R.id.lvsearch);

        database_appoint md = new database_appoint(getApplicationContext());
        ArrayList<String> al = md.showValues();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_listtext,al);

        lvsearch.setAdapter(ad);
    }
}
