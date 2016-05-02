/**
 * @author Giovana Mejia
 * 
 */
package com.example.supremelordjudah.beachelecticcompany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssignWorker extends AppCompatActivity {
    Spinner jobType, workerList;
    Button requestWorker;
    EditText location;
    View current;
    String job_type_url = "http://www.cs.loyola.edu/~gmejia/Project2/fillInJobType.php";
    ArrayList<String> jobs = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_worker);
        current = (View) findViewById(R.id.JobTypes);
        try {
            populateSpinner(current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void populateSpinner(View view) throws IOException {
        jobType = (Spinner) findViewById(R.id.JobTypes);


        backgroundWorker b = new backgroundWorker(this);
        b.execute("getJobList");

        String[] jobs = b.fetchStatus().split(" ");

        List<String> spinnerStuff = new ArrayList<String>();
        for(int i=0; i < jobs.length; i++)
        {
            System.out.println(jobs[i]);
            spinnerStuff.add(jobs[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerStuff);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        jobType.setAdapter(adapter);

    }

    }

