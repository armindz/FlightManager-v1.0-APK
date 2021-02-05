package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View.*;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;
import management.UserManagementSystem;

import database.UserDatabase;
import models.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v) {
                UserDatabase ud = new UserDatabase();

                String usernamedb = null;

                try {
                    Connection conn = DatabaseConnection.getConnection();
                    if (conn == null) throw new AssertionError();
                    Statement stmt = conn.createStatement();
                    ResultSet rset = stmt.executeQuery("SELECT * FROM users where Username = 'admin'");
                    while (rset.next()) {
                        usernamedb =rset.getString("Username");
                    }

                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ((TextView) findViewById(R.id.loginInfo)).setText("Check if username or password is valid" + usernamedb);

            }


        });
    }

    public void onClick(View view) {

        TextView user = findViewById(R.id.loginUsername);
        String username = user.getText().toString();

        TextView pw = findViewById(R.id.loginPassword);
        String password = pw.getText().toString();
        ((TextView) findViewById(R.id.loginInfo)).setText("Reviewing if  " + username + " is valid ");
        Log.d("usernameInformation" , username);
        Log.d("pwInformation", password);


        UserDatabase ud = new UserDatabase();
        UserManagementSystem ums = new UserManagementSystem();

      /*  String firstUser = ums.getUserList().get(0).getUsername();*/


     /*   String firstPass = ums.getUserList().get(0).getPassword();*/
        ((TextView) findViewById(R.id.loginInfo)).setText("Check if username or password is valid");
/*
        String usernamedb = null;

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM users where Username = 'admin'");
            while (rset.next()) {
                usernamedb =rset.getString("Username");



            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ((TextView) findViewById(R.id.loginInfo)).setText("Check if username or password is valid" + usernamedb);
        */
    }
}