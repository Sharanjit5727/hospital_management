package com.example.hospitalcse226;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class listview_doc extends AppCompatActivity {
    ListView listView ;
    Button appoint;
    // Array of strings storing country names
    String[] doctors = {"Dr.Kaler ",
            "Dr.Pannu",
            "Dr.Simran",
            "Dr.puneet",
            "Dr.Raman",
            "Dr.Anjali",
            "Dr.Sunitha",


    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images = {R.drawable.doc1,
            R.drawable.doc2,
            R.drawable.doc3,
            R.drawable.doc4,
            R.drawable.doc5,
            R.drawable.doc6,
            R.drawable.doc8,


    };
    String[] specialist={"cardiologist","dermotologist","gynaecologist","optholomologist","psychologist","dentist","neurologist"};


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_doc);

listView=findViewById(R.id.listview1);
doctors_list customAdapter= new doctors_list(getApplicationContext(),doctors,images,specialist);
listView.setAdapter(customAdapter);
    }
}