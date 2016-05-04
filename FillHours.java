package com.example.supremelordjudah.beachelectriccompany;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FillHours extends AppCompatActivity {

    EditText hoursWorkedEt, jobTypeEt;
    AlertDialog inputError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_hours);
        hoursWorkedEt = (EditText) findViewById(R.id.hoursWorkd);
        jobTypeEt = (EditText) findViewById(R.id.jobType);
    }


    public void OnSubmit(View view) {
        String email = MainActivity.getEmailAddress();

        inputError = new AlertDialog.Builder(this).create();
        inputError.setMessage("Only enter numbers please");
        String hoursWorked = hoursWorkedEt.getText().toString();
        String jobType = jobTypeEt.getText().toString();
            backgroundWorker b = new backgroundWorker(this);
        System.out.println(email + hoursWorked + jobType);
            b.execute("SubmitHours", email, hoursWorked, jobType);


    }
}
