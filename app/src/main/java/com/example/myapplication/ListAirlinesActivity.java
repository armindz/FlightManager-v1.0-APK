package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import management.AirlineManagementSystem;
import models.Airline;

public class ListAirlinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_airlines);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        AirlineManagementSystem airlinems = new AirlineManagementSystem();
        GridView airlinesList = (GridView) findViewById(R.id.airlinesList);
       // airlinesList.setColumnWidth(11);

        ArrayList <Airline> listOfAirlines = airlinems.getListOfAirlines();
        airlinesList.setAdapter(new ArrayAdapter<Airline>(this,R.layout.cell, listOfAirlines));


    }

    public void launchCreateActivity (View v) {
        Intent intent = new Intent (ListAirlinesActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    public void launchListActivity (View v) {
        Intent intent = new Intent (ListAirlinesActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void launchBookActivity (View v) {
        Intent intent = new Intent (ListAirlinesActivity.this, BookActivity.class);
        startActivity(intent);
    }
}