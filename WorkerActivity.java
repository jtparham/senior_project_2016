package com.example.supremelordjudah.beachelecticcompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WorkerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
    }

    public void fillWork(View view)
    {
        startActivity(new Intent(WorkerActivity.this, FillHours.class));
    }

    public void checkWork(View view){
        startActivity(new Intent(WorkerActivity.this, CheckJob.class));
    }

}


