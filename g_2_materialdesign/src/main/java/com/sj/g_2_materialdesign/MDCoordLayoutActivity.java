package com.sj.g_2_materialdesign;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.sj.commonres.BaseActivity;

public class MDCoordLayoutActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_md_coordinatorlayout;
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    //为按钮设置点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.add) {
            Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.delete) {
            Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.settings) {
            Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
        }else if (i == android.R.id.home) {
            //固定值，默认返回上一页
            Toast.makeText(this, "You clicked Back", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
