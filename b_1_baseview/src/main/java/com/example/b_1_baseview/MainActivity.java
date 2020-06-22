package com.example.b_1_baseview;

import com.example.b_1_baseview.baseview.EdittextActivity;
import com.example.b_1_baseview.recyclerview.first.FirstRVActivity;
import com.example.b_1_baseview.recyclerview.second.SecondRVActivity;
import com.example.b_1_baseview.recyclerview.third.ThirdRVActivity;
import com.sj.commonres.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSkip(findViewById(R.id.et), EdittextActivity.class);
        setSkip(findViewById(R.id.rv_first), FirstRVActivity.class);
        setSkip(findViewById(R.id.rv_second), SecondRVActivity.class);
        setSkip(findViewById(R.id.rv_third), ThirdRVActivity.class);
    }


}
