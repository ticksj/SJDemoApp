package com.sj.d_1_adaptiveversion.version_10;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.d_1_adaptiveversion.R;

public class UniqueActivity extends AppCompatActivity {

    private TextView msgTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unique);
        findViewById(R.id.get_device_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDeviceId();
            }
        });
        findViewById(R.id.get_android_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndroidId();
            }
        });
        msgTv = findViewById(R.id.msg);
    }

    private void getDeviceId() {
        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},1);
            return;
        }
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        msgTv.setText(
                "通过((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId() 来获取设备ID" + "\n" +
                "deviceId==" + deviceId);
    }

    private void getAndroidId() {
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        msgTv.setText(
                "通过Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID)来获取AndroidID" + "\n" +
                        "androidId==" + androidId);
    }


}
