package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import management.AirportManagementSystem;

public class CreateAirportActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_airport);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn = (Button) findViewById(R.id.createAirportBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView codename = (TextView) findViewById(R.id.airportCodenameTxt);
                String airportCodename = codename.getText().toString();

                TextView fullname = (TextView) findViewById(R.id.airportFullnameTxt);
                String airportFullname = fullname.getText().toString();

                TextView type = (TextView) findViewById(R.id.airportTypeTxt);
                String airportType = type.getText().toString();

                TextView city = (TextView) findViewById(R.id.airportCityTxt);
                String airportCity = city.getText().toString();

                TextView country = (TextView) findViewById(R.id.airportCountryTxt);
                String airportCountry = country.getText().toString();

                AirportManagementSystem airportms = new AirportManagementSystem();

                if (airportms.isAirportCodenameValid(airportCodename) && airportms.isAirportDataUnique(airportCodename)) {
                    airportms.createAirport(airportCodename,airportFullname,airportType,airportCity,airportCountry);

                    Toast.makeText(CreateAirportActivity.this, "Airport successfully created!", Toast.LENGTH_LONG).show();
                    launchListAirports(v);

                }
                else {
                    ((TextView)findViewById(R.id.createAirportNotification)).setText("Airport data not unique or codename not valid!");
                }


            }
        });

    }

    public void launchListAirports(View v) {
        Intent intent = new Intent(CreateAirportActivity.this, ListAirportsActivity.class);
        startActivity(intent);
    }
    public void launchCreateActivity (View v) {
        Intent intent = new Intent (CreateAirportActivity.this, CreateActivity.class);
        startActivity(intent);
    }

    public void launchListActivity (View v) {
        Intent intent = new Intent (CreateAirportActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void launchBookActivity (View v) {
        Intent intent = new Intent (CreateAirportActivity.this, BookActivity.class);
        startActivity(intent);
    }
}