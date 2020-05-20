package com.example.hospitalcse226;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
GridLayout gv;
CardView c3,c1,c2,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        c3 = (CardView) findViewById(R.id.card3);
        gv = (GridLayout) findViewById(R.id.maingrid);
        c1=(CardView)findViewById(R.id.card1);
        c2=(CardView)findViewById(R.id.card2);
        c4=(CardView)findViewById(R.id.card4);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc_list = new Intent(Main2Activity.this, listview_doc.class);
                startActivity(doc_list);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent make_app=new Intent(Main2Activity.this,appointment.class);
                startActivity(make_app);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_app=new Intent(Main2Activity.this,view_apppoint.class);
                startActivity(view_app);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(logout);
            }
        });
       /* setSingleEvent(gv);
    }

    private void setSingleEvent(GridLayout gv) {
        for (int i = 0; i < gv.getChildCount(); i++) {
            //since all the child items are card view we will cast object to gridview
            CardView cardview=(CardView)gv.getChildAt(i);

            final int final1=i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this, "Clicked at index "+final1, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }*/
    }
}
