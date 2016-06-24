package com.github.kazukinr.android.samples;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by kazuki on 2016/06/25.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
