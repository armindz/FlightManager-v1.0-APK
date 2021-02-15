package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

import management.FlightManagementSystem;
import models.Flight;

public class ListFlightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_flights);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        FlightManagementSystem flightms = new FlightManagementSystem();
        ArrayList<Flight> listOfFlights = flightms.getListOfFlights();

        GridView flightList = (GridView) findViewById(R.id.flightsList);
        flightList.setAdapter( new ArrayAdapter<>(this,R.layout.cell, listOfFlights));
    }

    public void launchCreateActivity(View v) {
        Intent intent = new Intent(ListFlightsActivity.this,CreateActivity.class);
        startActivity(intent);
    }
    public void launchListActivity(View v) {
        Intent intent = new Intent (ListFlightsActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void launchBookActivity(View v) {
        Intent intent = new Intent (ListFlightsActivity.this, BookActivity.class);
        startActivity(intent);
    }
}