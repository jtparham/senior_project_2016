package com.example.supremelordjudah.beachelecticcompany;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForemanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreman);
    }

    public void assignWorker(View view) {
        startActivity(new Intent(ForemanActivity.this, AssignWorker.class));
    }

    public void checkWorker(View view) {
        startActivity(new Intent(ForemanActivity.this, CheckWorker.class));
    }

    public void submitHours(View view) {
    }
}
