package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import models.User;
import java.util.ArrayList;

import database.UserDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // "Log in" button on main page used to check if input data is valid
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v) {

                // username input on mainActivity
                TextView usernameView = findViewById(R.id.loginUsername);
                String username = usernameView.getText().toString();
                // password input on mainActivity
                TextView passwordView = findViewById(R.id.loginPassword);
                String password = passwordView.getText().toString();
                // list of users from users database


                            if (isLoginDataValid(username, password)) {   // if input data is valid perform action
                                Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_LONG).show();
                                launchHomepage(v);
                            } else {        // if input data is not valid notify user to check for typos
                                ((TextView) findViewById(R.id.loginInfo)).setText("Check if username or password is valid");
                            }
                        }
                     }
               );}

    public boolean isLoginDataValid(String username, String password) {
        UserDatabase ud = new UserDatabase();
        ArrayList<User> userFromList = ud.fetchDatabaseContent();

        for (int i = 0; i < userFromList.size(); i++) {

            String usernameDb = ud.fetchDatabaseContent().get(i).getUsername();
            String passwordDb = ud.fetchDatabaseContent().get(i).getPassword();
            if (usernameDb.equals(username) && passwordDb.equals(password)) {   // if input data is valid return true
                return true;
            }
        }
        // if input data is not valid return false
        return false;
    }

    @Override
    public void onClick(View v) {
        // NOTHING TO IMPLEMENT YET
    }

    private void launchHomepage(View v) {

        Intent intent = new Intent(this, HomepageActivity.class);
        startActivity(intent);


    }
}