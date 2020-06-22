package com.sj.commonres;

import android.content.Intent;
import android.view.View;

/**
 * Created by SJ on 2020/5/14.
 */
public abstract class BaseMainActivity extends BaseActivity {

    protected void setSkip(View v, final Class cls){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseMainActivity.this,cls));
            }
        });
    }
    protected void setSkip(int vId, final Class cls){
        findViewById(vId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseMainActivity.this,cls));
            }
        });
    }
}
