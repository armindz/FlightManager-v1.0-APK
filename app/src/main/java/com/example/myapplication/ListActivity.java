package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void  launchListAirlines(View v) {
        Intent intent = new Intent(ListActivity.this, ListAirlinesActivity.class);
        startActivity( intent);
    }

    public void launchListAirports(View v) {
        Intent intent = new Intent (ListActivity.this, ListAirportsActivity.class);
        startActivity(intent);
    }

    public void launchCreateActivity (View v) {
        Intent intent = new Intent (ListActivity.this, CreateActivity.class);
        startActivity(intent);
    }
    public void launchBookActivity (View v) {
        Intent intent = new Intent (ListActivity.this, BookActivity.class);
        startActivity(intent);
    }
}