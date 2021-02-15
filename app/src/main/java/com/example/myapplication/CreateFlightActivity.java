package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

import management.AirlineManagementSystem;
import management.AirportManagementSystem;
import management.FlightManagementSystem;
import models.Airline;
import models.Flight;

public class CreateFlightActivity extends AppCompatActivity  implements View.OnClickListener {
    Button datePickerBtn, timePickerBtn;
    EditText dateTxt, timeTxt;
    private int year, month, day, hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flight);
        // hide action bar on this activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // ---------------------- airline codename input spinner -----------------------------------

        AirlineManagementSystem airlinems = new AirlineManagementSystem();
        ArrayList<String> listOfAirlineCodenames = new ArrayList<>();
        Spinner spinner = (Spinner) findViewById(R.id.airlineCodenameSpn);

        for (int i = 0; i < airlinems.getListOfAirlines().size(); i++) {
            String airlineCodename = airlinems.getListOfAirlines().get(i).getAirlineCodename();
            listOfAirlineCodenames.add(airlineCodename);
        }
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listOfAirlineCodenames));

        // --------------------- airport codename input spinner ------------------------------------

        AirportManagementSystem airportms = new AirportManagementSystem();
        ArrayList<String> listOfAirportCodenames = new ArrayList<>();
        spinner = (Spinner) findViewById(R.id.airportCodenameSpn);

         for (int i=0; i < airportms.getListOfAirports().size(); i++) {
            String airportCodename = airportms.getListOfAirports().get(i).getAirportCodename();
            listOfAirportCodenames.add(airportCodename);
        }
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, listOfAirportCodenames));


        // -------------------- destination airport codename input spinner -------------------------

        spinner = (Spinner) findViewById(R.id.destinationAirportCodenameSpn);
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, listOfAirportCodenames));


        // ---------------------------flight class input spinner -----------------------------------

        spinner = (Spinner) findViewById(R.id.flightClassSpn);
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,new String[]{"ECONOMY","BUSINESS","FIRST"}));


        // ------------------------- latest seat row input spinner ---------------------------------

        spinner = (Spinner) findViewById(R.id.seatRowsSpn);
        spinner.setAdapter(new ArrayAdapter<Character>(this,R.layout.support_simple_spinner_dropdown_item,new Character[]{'A','B','C','D','E','F'}));

        // ------------------------- seat number per row input data --------------------------------

        EditText seatNumber = (EditText) findViewById(R.id.seatsPerRow);
        int seatNum = Integer.parseInt(seatNumber.getText().toString());


        // ---------------------------- flight price input data ------------------------------------

        EditText flightPriceData = (EditText) findViewById(R.id.flightPrice);
        double flightPrice = Double.parseDouble(flightPriceData.getText().toString());

        // -------------------------- DATE TIME PICKER ---------------------------------------------

        datePickerBtn = (Button) findViewById(R.id.datePickerBtn);
        timePickerBtn = (Button) findViewById(R.id.timePickerBtn);
        dateTxt = (EditText) findViewById(R.id.dateTxt);
        timeTxt = (EditText) findViewById(R.id.timeTxt);


        datePickerBtn.setOnClickListener(this);
        timePickerBtn.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {

            // DATE PICKER
            if (v == datePickerBtn ) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dateTxt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }

            // TIME PICKER
            if (v == timePickerBtn) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                timeTxt.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        }



        }


