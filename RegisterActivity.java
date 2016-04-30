package com.example.supremelordjudah.beachelecticcompany;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText emailEt, passwordEt, firstNameEt, lastNameEt, foremanCodeEt;
    Button loginBt, registerBt;
    AlertDialog inputError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailEt = (EditText) findViewById(R.id.emailText);
        passwordEt = (EditText) findViewById(R.id.password);
        firstNameEt = (EditText) findViewById(R.id.firstName);
        lastNameEt = (EditText) findViewById(R.id.lastName);
        foremanCodeEt = (EditText) findViewById(R.id.formanCode);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        if (fab != null) {
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//            });
//        }
    }

    public void OnRegister(View view) {
        inputError = new AlertDialog.Builder(this).create();
        inputError.setMessage("Please fill out all boxes. The foreman code may be left" +
                " blank if not applicable.");
        String email;
        String password;
        String firstName;
        String lastName;
        String foremanCode;
        email = emailEt.getText().toString();
        password = passwordEt.getText().toString();
        firstName = firstNameEt.getText().toString();
        lastName = lastNameEt.getText().toString();
        foremanCode = foremanCodeEt.getText().toString();
        //inputError = new AlertDialog.Builder(this).create();
        inputError.setTitle("Invalid Input");

        if (    email.equals("") ||
                password.equals("") ||
                firstName.equals("") ||
                lastName.equals(""))
        {
            inputError.show();
        }
        else
        {

            String type = "register";
            backgroundWorker backgroundWorker = new backgroundWorker(this);
            backgroundWorker.execute(type, email, password, firstName, lastName, foremanCode);
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }
    }
}


