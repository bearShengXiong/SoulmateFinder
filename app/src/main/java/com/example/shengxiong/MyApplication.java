package com.example.shengxiong;

import android.app.Application;
import android.content.Context;

import java.io.Serializable;

/**
 * Created by Shengxiong on 2016/10/13.
 */
public class MyApplication extends Application implements Serializable{
    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
