package com.example.androidclasstest.Volley;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by MECHREVO on 2018/6/18.
 */

public class MyApplication extends Application{
    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
