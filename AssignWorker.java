package com.example.supremelordjudah.beachelecticcompany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AssignWorker extends AppCompatActivity {
    Spinner jobType, workerList;
    Button requestWorker;
    EditText location;
    String job_type_url = "http://www.cs.loyola.edu/~gmejia/Project2/fillInJobType.php";
    ArrayList<String> jobs = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_worker);
    }


    public void populateSpinner(View view) throws IOException {
        jobType = (Spinner) findViewById(R.id.JobTypes);


        URL url = new URL(job_type_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        //String post_data = URLEncoder.encode("Email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
        //        +URLEncoder.encode("Password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
        //bufferedWriter.write(post_data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
        String result = "";
        String line = "";
        while((line = bufferedReader.readLine()) !=null)
        {
            result += line;
        }
        bufferedReader.close();
        inputStream.close();
        httpURLConnection.disconnect();

    }

    }

