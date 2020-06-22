package com.sj.g_1_jetpack.googleproject.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 配置所有子类 可以被观察
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化工作



//        getLifecycle().addObserver();
    }
}
