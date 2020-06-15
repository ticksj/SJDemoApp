package com.sj.g_1_jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.g_1_jetpack.lifecycle.LifecycleActivity;
import com.sj.g_1_jetpack.viewmodel_livedata.PhoneActivity;

/**
 * 实现单一原则
 * Jetpack
 *
 * ViewModel  --  UI数据 管理视图控制册的数据
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhoneActivity.class));
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifecycleActivity.class));
            }
        });
    }
}
