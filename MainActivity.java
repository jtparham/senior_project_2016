package com.example.supremelordjudah.beachelectriccompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText passwordEt;
    EditText emailEt;
    static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replace_main);
        emailEt = (EditText) findViewById(R.id.emailCorrect);
        passwordEt = (EditText) findViewById(R.id.passwordCorrect);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    public void OnLogin(View view) {
        email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        String type = "login";
        backgroundWorker backgroundWorker = new backgroundWorker(this);

        backgroundWorker.execute(type, email, password);
    }

    public void OnRegister(View view) {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

    public static String getEmailAddress()
    {
        return email;
    }

}
