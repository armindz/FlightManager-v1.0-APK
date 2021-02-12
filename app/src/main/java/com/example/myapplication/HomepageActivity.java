package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void launchCreateActivity (View v) {

        Intent intent = new Intent(HomepageActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    public void launchListActivity (View v) {

        Intent intent = new Intent(HomepageActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void launchBookActivity (View v) {

        Intent intent = new Intent(HomepageActivity.this, BookActivity.class);
        startActivity(intent);
    }
}