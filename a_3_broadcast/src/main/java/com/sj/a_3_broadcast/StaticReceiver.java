package com.sj.a_3_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StaticReceiver extends BroadcastReceiver {

    private static final String TAG = "StaticReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, TAG + "onReceive: ", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
