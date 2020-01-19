package com.sj.d_1_adaptiveversion.version_6;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sj.d_1_adaptiveversion.R;

/**
 * Created by SJ on 2020/1/19.
 */
public class TestPermissionActivity extends PermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_permission);
        findViewById(R.id.request_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCamera();
            }
        });
    }

    private void requestCamera() {
        requestPermission(Manifest.permission.CAMERA, "需要拍照(此处解释下为啥需要这个权限)", new PermissionActivity.PermissionCallback() {
            @Override
            public void granted() {
                Toast.makeText(TestPermissionActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void denied() {
                Toast.makeText(TestPermissionActivity.this,"获取失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void waitUserInitiativeSet() {
                Toast.makeText(TestPermissionActivity.this,"用户设置中",Toast.LENGTH_SHORT).show();
            }
        });

    }

}