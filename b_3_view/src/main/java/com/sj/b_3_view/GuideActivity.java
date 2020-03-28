package com.sj.b_3_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.b_3_view.a_base.BaseActivity;
import com.sj.b_3_view.d_scroll_conflict.ScrollConflictActivity;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);


        findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, BaseActivity.class));
            }
        });
        findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, ScrollConflictActivity.class));
            }

        });

    }
}
