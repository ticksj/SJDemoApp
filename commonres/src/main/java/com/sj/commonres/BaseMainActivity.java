package com.sj.commonres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by SJ on 2020/5/14.
 */
public abstract class BaseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResID());
        initView();
    }

    protected abstract int setLayoutResID();

    protected abstract void initView();

    protected void setSkip(View v, final Class cls){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseMainActivity.this,cls));
            }
        });
    }
}
