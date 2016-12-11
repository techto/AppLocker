package com.balram.applocker;

import android.app.Application;

import com.balram.library.AppLocker;

/**
 * Created by Balram Pandey 12/11/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppLocker.getInstance().enableAppLock(this);
    }
}
