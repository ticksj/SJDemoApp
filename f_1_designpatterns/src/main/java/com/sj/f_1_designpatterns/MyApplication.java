package com.sj.f_1_designpatterns;

import android.app.Application;

/**
 * Created by SJ on 2020/3/22.
 */
public class MyApplication extends Application {
    private static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApplication getInstance(){
        return app;
    }
}
