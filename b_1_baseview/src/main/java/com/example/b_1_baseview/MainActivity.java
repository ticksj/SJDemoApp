package com.example.b_1_baseview;

import com.example.b_1_baseview.baseview.EdittextActivity;
import com.example.b_1_baseview.recyclerview.third.ThirdRVActivity;
import com.example.b_1_baseview.recyclerview.RVFirstActivity;
import com.example.b_1_baseview.recyclerview.RVSecondActivity;
import com.example.b_1_baseview.viewpager.VPFirstActivity;
import com.sj.commonres.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSkip(findViewById(R.id.et), EdittextActivity.class);
        setSkip(findViewById(R.id.tv_rv_first), RVFirstActivity.class);
        setSkip(findViewById(R.id.tv_rv_second), RVSecondActivity.class);
        setSkip(findViewById(R.id.rv_third), ThirdRVActivity.class);
        setSkip(findViewById(R.id.tv_vp), VPFirstActivity.class);
    }


}
