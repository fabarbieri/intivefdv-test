package com.example.intivefdvtest;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
