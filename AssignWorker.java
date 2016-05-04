package com.example.supremelordjudah.beachelectriccompany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssignWorker extends AppCompatActivity {
    private String stuff;
    Spinner jobType;
    static Spinner availableWorkers;
    EditText location;
    View current;

    static ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> jobs = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_worker);
        current = (View) findViewById(R.id.JobTypes);

        jobType = (Spinner) findViewById(R.id.JobTypes);
        availableWorkers = (Spinner) findViewById(R.id.workerSelect);
        location = (EditText) findViewById(R.id.locationField);

        List<String> listWorkers = new ArrayList<String>();
        listWorkers.add("Plumbing");
        listWorkers.add("Electrical");
        listWorkers.add("Drywall");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listWorkers);
        jobType.setAdapter(adapter);


    }


    public void populateSpinner(View view) throws IOException, InterruptedException {
        backgroundWorker b = new backgroundWorker(this, findViewById(android.R.id.content));
        b.execute("getWorkers", jobType.getSelectedItem().toString());
        addWorkers();
    }

    public void addWorkers() {
        String[] workers = stuff.split(",");

        for(int i =0; i < workers.length; i++)
        {
            System.out.println(workers[i]);
            result.add(workers[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, result);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        availableWorkers.setAdapter(adapter);
    }

    public void editStuff(String s)
    {
        System.out.println("PASS INTO EDIT STRING: " +s);
        stuff = s;
        System.out.println("RESULT OF EDIT STRING: " +stuff);


    }

    public void submitJob(View view) {
        backgroundWorker b = new backgroundWorker(this, findViewById(android.R.id.content));
        b.execute("sendWork", jobType.getSelectedItem().toString(), availableWorkers.getSelectedItem().toString(), location.getText().toString());
    }
}

