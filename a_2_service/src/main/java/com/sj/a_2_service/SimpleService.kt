package com.sj.a_2_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class SimpleService : Service() {
    var TAG = "SimpleService"
    var binder = CountBinder()

    override fun onCreate() {
        Log.e(TAG,"Service Create")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG,"Service Start")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.e(TAG,"Service Bind")
        binder.count++
       return binder
    }

    override fun onRebind(intent: Intent?) {
        Log.e(TAG,"Service onRebind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG,"Service UnBind")
//        return super.onUnbind(intent)
        return true
    }

    override fun onDestroy() {
        Log.e(TAG,"Service Destory")
        super.onDestroy()
    }

    public class CountBinder : Binder(){
        var TAG="CountBinder"
        var count = 0;
        fun startRecord(){Log.e(TAG,"Binder startRecord")}
        fun stopRecord(){Log.e(TAG,"Binder stopRecord")}
    }
}
