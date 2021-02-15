package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }


    public void launchCreateAirlineActivity(View v) {
        Intent intent = new Intent(CreateActivity.this, CreateAirlineActivity.class);
        startActivity(intent);

    }

    public void launchCreateAirportActivity(View v) {
        Intent intent = new Intent (CreateActivity.this, CreateAirportActivity.class);
        startActivity(intent);
    }

    public void launchListActivity (View v) {
        Intent intent = new Intent (CreateActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void launchBookActivity (View v) {
        Intent intent = new Intent (CreateActivity.this, BookActivity.class);
        startActivity(intent);
    }

    public void launchCreateFlightActivity(View v) {
        Intent intent = new Intent (CreateActivity.this, CreateFlightActivity.class);
        startActivity(intent);
    }

}