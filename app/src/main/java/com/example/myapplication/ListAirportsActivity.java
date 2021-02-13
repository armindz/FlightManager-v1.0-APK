package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

import management.AirportManagementSystem;
import models.Airport;

public class ListAirportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_airports);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        AirportManagementSystem airportms = new AirportManagementSystem();
        GridView airportsList = (GridView) findViewById(R.id.airportsList);

        ArrayList <Airport> listOfAirports = airportms.getListOfAirports();
        airportsList.setAdapter( new ArrayAdapter <Airport> (this,R.layout.cell, listOfAirports));
    }

    public void launchCreateActivity (View v) {
        Intent intent = new Intent (ListAirportsActivity.this, CreateActivity.class);
        startActivity(intent);
    }
    public void launchListActivity (View v) {
        Intent intent = new Intent (ListAirportsActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void launchBookActivity (View v) {
        Intent intent = new Intent (ListAirportsActivity.this, BookActivity.class);
        startActivity(intent);
    }


}