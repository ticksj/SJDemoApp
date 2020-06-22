package com.example.b_1_baseview.recyclerview.third;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_1_baseview.R;
//1. RV的增量更新          DiffUtil.Callback
public class ThirdRVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_rv);
    }
}
