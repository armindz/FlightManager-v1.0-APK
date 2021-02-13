package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void launchCreateActivity (View v) {
        Intent intent = new Intent (BookActivity.this, CreateActivity.class);
        startActivity(intent);
    }
    public void launchListActivity (View v) {
        Intent intent = new Intent (BookActivity.this, ListActivity.class);
        startActivity(intent);
    }
}