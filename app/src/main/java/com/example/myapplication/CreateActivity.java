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
}