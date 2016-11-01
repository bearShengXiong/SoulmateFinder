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
 * Created by Shengxiong on 2016/10/24.
 */

public class BackGroundTask2 extends AsyncTask<String,Void,String>{

    String json_url,json_url2,json_url3;
    Context mContext;
    String JSON_STRING,JSON_STRING2;
    public BackGroundTask2(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        json_url = "http://10.11.88.48/webapp/retrieve.php";
        json_url2 = "http://10.11.88.48/webapp/returnretrieve.php";
        json_url3 = "http://10.11.88.48/webapp/user_email_retrieve.php";
    }

    @Override
    protected String doInBackground(String... params) {


        String method = params[0];
       if(method.equals("retrieve")) {
           String name = params[1];
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(name,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine())!=null )
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("returnretrieve")) {
           String name = params[1];
           try {
               URL url = new URL(json_url2);
               HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
               httpURLConnection.setRequestMethod("POST");
               httpURLConnection.setDoOutput(true);
               OutputStream OS = httpURLConnection.getOutputStream();
               BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
               String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(name,"UTF-8");
               bufferedWriter.write(data);
               bufferedWriter.flush();
               bufferedWriter.close();
               OS.close();
               InputStream IS = httpURLConnection.getInputStream();
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
               StringBuilder stringBuilder = new StringBuilder();
               while ((JSON_STRING2 = bufferedReader.readLine())!=null )
               {
                   stringBuilder.append(JSON_STRING2+"\n");
               }
               bufferedReader.close();
               IS.close();
               httpURLConnection.disconnect();
               return stringBuilder.toString().trim();
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }else if(method.equals("emailretrieve")) {
           String name = params[1];
           try {
               URL url = new URL(json_url3);
               HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
               httpURLConnection.setRequestMethod("POST");
               httpURLConnection.setDoOutput(true);
               OutputStream OS = httpURLConnection.getOutputStream();
               BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
               String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
               bufferedWriter.write(data);
               bufferedWriter.flush();
               bufferedWriter.close();
               OS.close();
               InputStream IS = httpURLConnection.getInputStream();
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS));
               StringBuilder stringBuilder = new StringBuilder();
               while ((JSON_STRING2 = bufferedReader.readLine()) != null) {
                   stringBuilder.append(JSON_STRING2 + "\n");
               }
               bufferedReader.close();
               IS.close();
               httpURLConnection.disconnect();
               return stringBuilder.toString().trim();
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

    }
}
