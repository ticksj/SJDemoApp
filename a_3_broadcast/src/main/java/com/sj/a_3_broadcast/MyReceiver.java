package com.sj.a_3_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    public static final String ACTION_ONE = "com.broadcast.custommsg.one";
    public static final String ACTION_TWO = "com.broadcast.custommsg.two";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_ONE.equals(intent.getAction())) {
            Toast.makeText(context,TAG+"onReceive: " + "ACTION_ONE",Toast.LENGTH_SHORT).show();
        }
        if (ACTION_TWO.equals(intent.getAction())) {
            Toast.makeText(context,TAG+"onReceive: " + "ACTION_TWO",Toast.LENGTH_SHORT).show();
        }
    }
}
