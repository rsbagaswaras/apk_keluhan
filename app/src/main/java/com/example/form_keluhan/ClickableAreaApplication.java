package com.example.form_keluhan;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class ClickableAreaApplication extends Application {

    //library untuk clikable

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}