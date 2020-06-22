package com.sj.g_1_jetpack.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Created by SJ on 2020/4/27.
 */
public class Percipient implements DefaultLifecycleObserver {
    private static final String TAG = "Percipient";
    private static Percipient percipient;

    public static Percipient getInstance() {
        if (percipient == null) {
            synchronized (Percipient.class) {
                if (percipient == null) {
                    percipient = new Percipient();
                }
            }
        }
        return percipient;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onCreate:");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onStart:");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onResume:");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onPause:");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onStop:");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.e(TAG,"onDestroy:");
    }
}
