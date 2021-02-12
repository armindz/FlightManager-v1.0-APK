package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import management.AirlineManagementSystem;
import models.Airline;

public class CreateAirlineActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_airline);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // "Create airline" button on CreateAirlineActivity used to create airline if input data is valid
        btn = (Button) findViewById(R.id.createAirlineBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // airline codename input on CreateAirlineActivity
                TextView codename = (TextView) findViewById(R.id.airlineCodenameTxt);
                String airlineCodename = codename.getText().toString();
                // airline callsign input on CreateAirlineActivity
                TextView callsign = (TextView) findViewById(R.id.airlineCallsignTxt);
                String airlineCallsign = callsign.getText().toString();
                // airline country input  on CreateAirlineActivity
                TextView country = (TextView) findViewById(R.id.airlineCountryTxt);
                String airlineCountry = country.getText().toString();

                AirlineManagementSystem airlinems = new AirlineManagementSystem();

                // proceed if input data is valid otherwise notify user to check input data
                if (airlinems.isAirlineCodenameValid(airlineCodename) && airlinems.isAirlineDataUnique(airlineCodename)) {
                    airlinems.createAirline(airlineCodename, airlineCallsign, airlineCountry);
                    Toast.makeText(CreateAirlineActivity.this, "Successfully created", Toast.LENGTH_LONG).show();
                    launchListAirlines(v);

                }
                else {
                    ((TextView) findViewById(R.id.createAirlineNotification)).setText("Airline not unique or codename not valid!");
                }
            }
        });
    }

    public void  launchListAirlines (View v) {
        Intent intent = new Intent(CreateAirlineActivity.this, ListAirlinesActivity.class);
        startActivity( intent);
    }
}