package com.example.supremelordjudah.beachelectriccompany;

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
public class bgWorker extends AsyncTask<String, Void, String> {
    Context context;
    //    private Activity activity;
    AlertDialog alertDialog;
    private String actionToPerform;
    String type;


    bgWorker (Context ctx){
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
        String register_url = "http://www.cs.loyola.edu/~gmejia/Project2/insert.php";//works
        String check_login_url = "http://www.cs.loyola.edu/~gmejia/Project2/checkUserLogin.php";//works
        String submit_hours_url = "http://www.cs.loyola.edu/~gmejia/Project2/submitHoursEmail.php";//what
        String send_Jobs = "http://www.cs.loyola.edu/~gmejia/Project2/sendJobs.php";//not there yet
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
                //System.out.println(check_login_url+post_data);
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

        else if (type.equals("SubmitHours"))
        {
            try {
                String userEmail = params[1];
                String hoursWorked = params[2];
                String jobType = params[3];
                URL url = new URL(submit_hours_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("jobHours", "UTF-8")+"="+URLEncoder.encode(hoursWorked, "UTF-8")+"&"
                        +URLEncoder.encode("jobType", "UTF-8")+"="+URLEncoder.encode(jobType, "UTF-8")+"&"
                        +URLEncoder.encode("userEmail", "UTF-8")+"="+URLEncoder.encode(userEmail, "UTF-8");
                System.out.println(submit_hours_url+post_data);
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
                System.out.println(result);
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
                String userEmail = params[1];
                URL url = new URL(populateJobs);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("userEmail", "UTF-8")+"="+URLEncoder.encode(userEmail, "UTF-8");

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
                return result;
            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("getJobList"))
        {
            try {

                URL url = new URL(populateJobs);
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
                System.out.println("CHECK HERE JOBLIST: "+ result);
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

        else if (type.equals("getWorkers"))
        {
            try {
                String jobType = params[1];
                URL url = new URL(populateWorkers);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("JobTipo", "UTF-8")+"="+URLEncoder.encode(jobType, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream, "iso-8859-1")));
                //ArrayList<String> names = new ArrayList<>();
                String names = "";
                String line = "";
                while((line = bufferedReader.readLine()) !=null)
                {
                    names += (line);
                    //names.add(line);
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                //System.out.println(names.size()); only one thing inside the array

                String[] correctedArray;
                correctedArray = names.split(",");

                String result = "";
                result += correctedArray[0];
                for(int i =1; i < correctedArray.length; i++)
                {
                    result += ":"+correctedArray[i];
                    //System.out.println(result + i);
                }
                result = result.replace("[", "");
                result = result.replace("\"", "");
                result = result.replace("]", "");

                System.out.println("PLAIN: " +result);

                System.out.println("BEFORE SET FETCH: " +fetchStatus());

                setActionToPerform(result);
                System.out.println("AFTER SET FETCH: " +fetchStatus());
                //System.out.println("Number of Indices: "+correctedArray.length);
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
        actionToPerform = fetchStatus();
    }

    @Override
    protected void onPostExecute(String result) {
        setActionToPerform(result);
        System.out.println("IDENTIFIER: "+result);
        System.out.println("IDENTIFIER2: "+fetchStatus());

        if(type.equals("login")) {
            alertDialog.setMessage(result);
            alertDialog.show();

            if (result.equals("you are a worker")) {
                context.startActivity(new Intent(context, WorkerActivity.class));
            }
            else if (result.equals("you are a foreman")) {
                context.startActivity(new Intent(context, ForemanActivity.class));
            }
        }

        else if(type.equals("SubmitHours"))
        {
            alertDialog.setTitle("Submit Hours");
            if(result.equals("Successfully addedJob deletedJob removed"))
            {
                result = "You have submitted your hours successfully";
            }
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



    public String fetchStatus() {

        System.out.println("PRINT ON FETCH: "+actionToPerform);
        return actionToPerform;
    }

    public void setActionToPerform(String actionToPerform) {
        this.actionToPerform = actionToPerform;
    }
}
