package com.aaxs.nitrov17.pullhtml_demo;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by NitroV17 on 10/31/2016.
 */

public class Downloader extends AsyncTask<String,Void,String> {

    String result;
    URL url;
    HttpURLConnection urlConnection;
    InputStream inputStream;
    InputStreamReader inputStreamReader;
    int data;

    protected String doInBackground(String... strings) {

        try {
            url=new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();
            inputStreamReader=new InputStreamReader(inputStream);
            data=inputStreamReader.read();
            while (data != -1)
            {
                char current =(char) data;
                result+=current;
                data=inputStreamReader.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
