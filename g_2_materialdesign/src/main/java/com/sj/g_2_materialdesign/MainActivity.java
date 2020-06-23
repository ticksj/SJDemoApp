package com.sj.g_2_materialdesign;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.sj.commonres.BaseMainActivity;

public class MainActivity extends BaseMainActivity {
    private LinearLayout llContent;
    private TextInputLayout til;



    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tv_snackbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar();
            }
        });
        llContent = (LinearLayout) findViewById(R.id.ll_content);
        til = (TextInputLayout) findViewById(R.id.til);
        setTIL();
        setSkip(R.id.tv_1, MDDrawerTabNavigationVPActivity.class);
        setSkip(R.id.tv_2, MDCoordLayoutActivity.class);
        setSkip(R.id.tv_3, MDDrawerTabNavigationVPActivity.class);
    }

    private void setTIL() {
        til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length()<6) {
                    til.setErrorEnabled(true);
                    til.setError("长度过短！");
                }else {
                    til.setErrorEnabled(false);
                }
            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(llContent,"这是一条Snackbar！",Snackbar.LENGTH_SHORT)
                .setAction("点击事件", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击Snackbar", Toast.LENGTH_SHORT).show();
                    }
                })
                .setDuration(Snackbar.LENGTH_SHORT).show();
    }
}
