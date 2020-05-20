package com.example.hospitalcse226;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class doctors_list extends BaseAdapter {


    String doctorslist[];
    int imgs[];
    String specialist[];


    LayoutInflater inflter;

    public doctors_list(Context applicationContext, String[] doctorslist, int[] imgs,String[] specialist) {
        //  this.context = context;
        this.doctorslist= doctorslist;
        this.imgs = imgs;
        this.specialist=specialist;

        inflter = (LayoutInflater.from(applicationContext));  //where we want to inflate the layout answer is applicationcontext
    }

    @Override
    public int getCount() {    //returns the total number of items in the list
        return doctorslist.length;
    }

    @Override
    public Object getItem(int i) {    //to get the data item
        return null;
    }

    @Override
    public long getItemId(int i) {      //get the item position
        return 0;
    }

    @Override

    public View getView(int i, View view, ViewGroup viewGroup) {     // set the layout and add the data items
        view = inflter.inflate(R.layout.activity_doctors_list, null);
        TextView fruit = (TextView) view.findViewById(R.id.tv1);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        TextView proff=(TextView)view.findViewById(R.id.tv2);

        fruit.setText(doctorslist[i]);
        icon.setImageResource(imgs[i]);
        proff.setText(specialist[i]);
        return view;
    }
}

