package com.sj.a_3_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    private NetworkChangedReceiver receiver;
    private MyReceiver myReceiver;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.t1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerSystemBroadcast();
            }
        });
        findViewById(R.id.t2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unRegisterSystemBroadcast();
            }
        });
        findViewById(R.id.t3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomB1();
            }
        });
        findViewById(R.id.t4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticOrderB();
            }
        });
        findViewById(R.id.t5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCustomB();
            }
        });
        findViewById(R.id.t6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unRegisterCustomB();
            }
        });
    }

    private void sendStaticOrderB() {
//        sendBroadcast(new Intent("com.j.order.test"),null);
        sendBroadcast(new Intent("com.j.order.test"),"com.j.order");
    }


    private void registerSystemBroadcast() {
        receiver = new NetworkChangedReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, filter);
    }

    private void unRegisterSystemBroadcast() {
        unregisterReceiver(receiver);
    }

    private void registerCustomB() {
        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.ACTION_ONE);
        filter.addAction(MyReceiver.ACTION_TWO);
        registerReceiver(myReceiver, filter);
    }

    private void unRegisterCustomB() {
        unregisterReceiver(myReceiver);
    }

    private void sendCustomB1() {
        sendBroadcast(new Intent(MyReceiver.ACTION_ONE));
    }

    private void sendCustomB2() {
        sendBroadcast(new Intent(MyReceiver.ACTION_TWO),null);
    }

    private void sendAndReceiveB(){
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        String action = "com.j.local.b";
        filter.addAction(action);
        localReceiver = new LocalReceiver();
        broadcastManager.registerReceiver(localReceiver, filter);
        broadcastManager.sendBroadcast(new Intent(action));
    }
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (localReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
        }
    }
}
