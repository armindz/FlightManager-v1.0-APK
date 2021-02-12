package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}