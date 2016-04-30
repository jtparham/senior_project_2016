package com.example.supremelordjudah.beachelecticcompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText emailEt, passwordEt, firstNameEt, lastNameEt, foremanCodeEt;
    Button loginBt, registerBt;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEt = (EditText) findViewById(R.id.emailText);
        passwordEt = (EditText) findViewById(R.id.password);
        firstNameEt = (EditText) findViewById(R.id.firstName);
        lastNameEt = (EditText) findViewById(R.id.lastName);
        foremanCodeEt = (EditText) findViewById(R.id.formanCode);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    public void OnLogin(View view) {
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";
        backgroundWorker backgroundWorker = new backgroundWorker(this);

        backgroundWorker.execute(type, email, password);
    }

    public void OnRegister(View view) {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

}
