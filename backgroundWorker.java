package com.example.supremelordjudah.beachelecticcompany;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Supreme Lord Judah on 4/27/2016.
 */
public class backgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    private Activity activity;
    AlertDialog alertDialog;
    private String actionToPerform;
    String type;


    backgroundWorker (Context ctx){
        context = ctx;
    }
    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    public String doInBackground(String... params) {
        type = params[0];
        String register_url = "http://www.cs.loyola.edu/~gmejia/Project2/insert.php";
        String check_login_url = "http://www.cs.loyola.edu/~gmejia/Project2/checkUserLogin.php";
        String submit_hours_url = "http://www.cs.loyola.edu/~gmejia/Project2/submitHours.php";
        String send_Jobs = "http://www.cs.loyola.edu/~gmejia/Project2/sendJobs.php";
        String populateWorkers = "http://www.cs.loyola.edu/~gmejia/Project2/fillInWorker.php";
        String populateJobs = "http://www.cs.loyola.edu/~gmejia/Project2/fillInJobType.php";

        if(type.equals("register"))
        {
            try {

                String email = params[1];
                String password = params[2];
                String firstName = params[3];
                String lastName = params[4];
                String foreman = params[5];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("FirstName", "UTF-8")+"="+URLEncoder.encode(firstName, "UTF-8")+"&"
                        +URLEncoder.encode("LastName", "UTF-8")+"="+URLEncoder.encode(lastName, "UTF-8")+"&"
                        +URLEncoder.encode("Email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("Password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8")+"&"
                        +URLEncoder.encode("Foreman", "UTF-8")+"="+URLEncoder.encode(foreman, "UTF-8");
                bufferedWriter.write(post_data);
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
                return result;
            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("login"))
        {
            try {

                String email = params[1];
                String password = params[2];
                URL url = new URL(check_login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                        +URLEncoder.encode("Password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
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
                setActionToPerform(result);
                System.out.println("AMIRITE " + result);
                System.out.println("AMIRITE " + fetchStatus());
                return result;
            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (type.equals("SubmitHours"))
        {
            try {

                String hoursWorked = params[1];

                URL url = new URL(submit_hours_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //TODO: FIX ME
                String post_data = URLEncoder.encode("plumbingHours", "UTF-8")+"="+URLEncoder.encode(hoursWorked, "UTF-8")+"&"
                        +URLEncoder.encode("plumbingHours", "UTF-8")+"="+URLEncoder.encode(hoursWorked, "UTF-8");

                bufferedWriter.write(post_data);
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
                return result;
            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (type.equals("getJobType"))
        {
            try {

                URL url = new URL(populateJobs);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //TODO: FIX ME
                //String post_data = URLEncoder.encode("plumbingHours", "UTF-8")+"="+URLEncoder.encode(hoursWorked, "UTF-8")+"&"
                 //       +URLEncoder.encode("plumbingHours", "UTF-8")+"="+URLEncoder.encode(hoursWorked, "UTF-8");

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
                setActionToPerform(result);
                return result;
            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println("Le current job is " +result);

        if(type.equals("login")) {
            alertDialog.setMessage(result);
            alertDialog.show();
            if (result.equals("you are a worker")) {
                context.startActivity(new Intent(context, WorkerActivity.class));
            } else if (result.equals("you are a foreman")) {
                context.startActivity(new Intent(context, ForemanActivity.class));
            }
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



    public String fetchStatus() {
        return actionToPerform;
    }

    public void setActionToPerform(String actionToPerform) {
        this.actionToPerform = actionToPerform;
    }
}
