package com.sj.d_1_adaptiveversion.version_10;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.sj.d_1_adaptiveversion.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class UniqueActivity extends AppCompatActivity {

    private TextView msgTv;
    private WifiManager wifiManager;

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
        findViewById(R.id.get_mac_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMacAddress();
            }
        });
        findViewById(R.id.get_serial_number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSN();
            }
        });
        findViewById(R.id.create_uuid_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUUID_1();
            }
        });
        findViewById(R.id.get_uuid_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUUID_1();
            }
        });
        findViewById(R.id.create_uuid_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUUID_2();
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
        msgTv.setText("通过((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId() 来获取设备ID"
                + "\n"
                + "deviceId==" + deviceId);
    }

    private void getAndroidId() {
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        msgTv.setText("通过Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID)来获取AndroidID"
                + "\n"
                + "androidId==" + androidId);
    }

    private void getMacAddress() {
        wifiManager = ((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE));
        String macAddress = wifiManager.getConnectionInfo().getMacAddress();
        msgTv.setText("通过((WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress() 来获取MacAddress"
                + "\n"
                + "macAddress==" + macAddress);
    }

    private void getSN() {
        msgTv.setText("通过 android.os.Build.SERIAL"
                + "\n"
                + "Build.SERIAL==" + Build.SERIAL);
    }


    private void createUUID_1() {
        String uniqueID = UUID.randomUUID().toString();
        msgTv.setText("通过UUID.randomUUID().toString()"
                + "\n"
                + "uniqueID==" + uniqueID);
        saveUUID(uniqueID);
    }

    private void getUUID_1() {
        msgTv.setText("获取保存的UUID"
                + "\n"
                + "uniqueID==" + readUUID());
    }

    private void createUUID_2() {
        if (requestPermission()) {
            return;
        }
        UniqueIDUtils.clearUniqueFile(getApplicationContext());
        String uniqueID = UniqueIDUtils.getUniqueID(getApplicationContext());
        msgTv.setText("通过UniqueIDUtils获取唯一识别码"
                + "\n"
                + "uniqueID==" + uniqueID);
    }



    private void saveUUID(String uniqueID) {
        requestPermission();
        File filesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        if (filesDir.isDirectory()) {
            File file = new File(filesDir, "uuidfile.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(uniqueID.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private String readUUID() {
        File filesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(filesDir, "uuidfile.txt");
        if (file.exists()) {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                return new String(bytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return "";
    }

    private boolean requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
        &&ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE}, 1);
//            ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return true;
        }
        return false;
    }

}
