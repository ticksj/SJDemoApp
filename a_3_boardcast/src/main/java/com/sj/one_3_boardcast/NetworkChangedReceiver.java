package com.sj.one_3_boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkChangedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            if (!info.isAvailable()) {
                Toast.makeText(context,TAG+"onReceive: " + "network 不可用",Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(context,TAG+"onReceive: " + "network 可用",Toast.LENGTH_SHORT).show();
            switch (info.getType()) {
                case ConnectivityManager.TYPE_MOBILE:
                    Toast.makeText(context,TAG+"onReceive: " + "network is TYPE_MOBILE",Toast.LENGTH_SHORT).show();
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    Toast.makeText(context,TAG+"onReceive: " + "network is TYPE_WIFI",Toast.LENGTH_SHORT).show();
                    break;
            }
        }else {
            Toast.makeText(context,TAG+"onReceive: " + "无network",Toast.LENGTH_SHORT).show();
        }
    }
}
