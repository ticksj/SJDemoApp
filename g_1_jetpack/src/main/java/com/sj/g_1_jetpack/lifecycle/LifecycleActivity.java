package com.sj.g_1_jetpack.lifecycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.g_1_jetpack.R;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        getLifecycle().addObserver(Percipient.getInstance());
    }


}
