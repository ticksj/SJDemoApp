package com.sj.base_database;

import android.app.Application;

import com.sj.base_database.base.DBUtils;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBUtils.init(this);
    }
}
