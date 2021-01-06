package com.abhi245y.watchthis.Extra;

import android.app.Application;
import com.singhajit.sherlock.core.Sherlock;


public class SendErrorACRA extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Sherlock.init(this); //Initializing Sherlock
        Sherlock.getInstance().getAllCrashes();
    }
}
