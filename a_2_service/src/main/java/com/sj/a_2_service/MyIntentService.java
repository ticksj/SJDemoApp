package com.sj.a_2_service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by SJ on 2019/12/9.
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e(TAG, "onHandleIntent: " );
    }
}
