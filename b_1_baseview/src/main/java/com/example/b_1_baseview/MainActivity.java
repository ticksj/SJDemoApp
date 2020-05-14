package com.example.b_1_baseview;

import com.example.b_1_baseview.recyclerview.first.FirstRVActivity;
import com.sj.commonres.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSkip(findViewById(R.id.rv_first), FirstRVActivity.class);
    }


}
