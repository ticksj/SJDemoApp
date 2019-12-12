package com.sj.a_2_service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    var count=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start_simple_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var intent=Intent(this@MainActivity,SimpleService::class.java)
                startService(intent)
            }
        })
        stop_simple_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var intent=Intent(this@MainActivity,SimpleService::class.java)
                intent.action="android.intent.action.SimpleService"
                intent.`package`=this@MainActivity.packageName
                stopService(intent)
            }
        })
        bind_simple_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var intent=Intent(this@MainActivity,SimpleService::class.java)
                count++
                intent.type="c"+count
                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)
            }
        })
        unbind_simple_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                unbindService(serviceConnection)
            }
        })
        start_foreground_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startService(Intent(this@MainActivity,ForegroundService::class.java))
            }
        })
        start_intent_service_tv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startService(Intent(this@MainActivity,MyIntentService::class.java))
            }
        })
    }
    lateinit var binder: SimpleService.CountBinder
    var serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.e(TAG,"异常解绑时调用")
        }
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.e(TAG,"成功绑定")
            binder = p1 as SimpleService.CountBinder;
            binder.startRecord()
            binder.stopRecord()
            Log.e(TAG,""+binder.count+"")
        }
    }
}
