package com.example.shengxiong.soulmatefinder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.shengxiong.soulmatefinder.ui.ChoiceActivity;

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
 * Created by Shengxiong on 2016/10/16.
 */

public class BackGroundTask extends AsyncTask<String,Void,String>{
    AlertDialog mAlertDialog;
    Context mContext;
    String JSON_STRING;
    public BackGroundTask(Context context) {
        this.mContext = context;

    }

    @Override
    protected void onPreExecute() {
      mAlertDialog = new AlertDialog.Builder(mContext).create();
        mAlertDialog.setTitle("Login Information");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.11.88.48/webapp/register.php";
        String login_url = "http://10.11.88.48/webapp/login.php";
        String upload_url = "http://10.11.88.48/webapp/upload.php";
        String return_url = "http://10.11.88.48/webapp/return.php";
        String method = params[0];
        if(method.equals("register")){
            String user_email = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user_email","UTF-8") +"="+URLEncoder.encode(user_email,"UTF-8") + "&"+
                        URLEncoder.encode("user_name","UTF-8") +"="+URLEncoder.encode(user_name,"UTF-8") + "&"+
                        URLEncoder.encode("user_pass","UTF-8") +"="+URLEncoder.encode(user_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success..";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (method.equals("login")){
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+ "=" + URLEncoder.encode(login_name,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+ "=" + URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line ="";
                while ((line = bufferedReader.readLine())!=null){
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(method.equals("upload")) {
            String user = params[1];
            String answer = params[2];
            String question = params[3];
            String garbled = params[4];

            try {
                URL url = new URL(upload_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(user,"UTF-8") + "&"+
                        URLEncoder.encode("user_data", "UTF-8") + "=" + URLEncoder.encode(answer, "UTF-8")+"&"+
                        URLEncoder.encode("user_question", "UTF-8") + "=" + URLEncoder.encode(question, "UTF-8")+"&"+
                        URLEncoder.encode("user_garbled", "UTF-8") + "=" + URLEncoder.encode(garbled, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Upload Success..";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("return")) {
            String user = params[1];
            String user_return = params[2];

            try {
                URL url = new URL(return_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(user,"UTF-8") + "&"+
                        URLEncoder.encode("user_return", "UTF-8") + "=" + URLEncoder.encode(user_return, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Upload Success..";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        String string = result;
        if(result.equals("Registration Success..")){
            Toast.makeText(mContext,result,Toast.LENGTH_LONG).show();
        }else if(result.equals("Login Success...Welcome")) {
            Toast.makeText(mContext,result,Toast.LENGTH_LONG).show();
            Intent i = new Intent(mContext,ChoiceActivity.class);
            mContext.startActivity(i);
        }else if(result.equals("Upload Success..")){
            Toast.makeText(mContext,result,Toast.LENGTH_LONG).show();
        }else {
                mAlertDialog.setMessage(result);
                mAlertDialog.show();
            }
    }

}
