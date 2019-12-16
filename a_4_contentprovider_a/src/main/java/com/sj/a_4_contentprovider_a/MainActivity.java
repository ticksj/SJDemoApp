package com.sj.a_4_contentprovider_a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView msgTv;
    private TextView contentTv;

    private Uri selfContentUri = Uri.parse("content://com.sj.a_4_contentprovider_b.provider/dtable");
    private String newDataId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.get_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readContacts();
            }
        });
        findViewById(R.id.i_custom_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        findViewById(R.id.d_custom_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
        findViewById(R.id.u_custom_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        findViewById(R.id.q_custom_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryData();
            }
        });
        msgTv = findViewById(R.id.msg);
        contentTv = findViewById(R.id.content);
    }

    private void readContacts() {
        contentTv.setText("");
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                msgTv.setText(msgTv.getText().toString() + "\n" + "readContacts: " + name + ":" + number);
            }
        }

    }

    private void insertData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("d1", "ADD" + System.currentTimeMillis() + "");
        contentValues.put("d2", "ADD" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Uri newDataUri = getContentResolver().insert(selfContentUri, contentValues);
        newDataId = newDataUri.getPathSegments().get(0);
    }

    private void deleteData() {
        if (TextUtils.isEmpty(newDataId)) {
            Toast.makeText(this,"请先添加",Toast.LENGTH_SHORT).show();
            return;
        }
        getContentResolver().delete(selfContentUri, "id=?", new String[]{newDataId});
    }

    private void updateData() {
        if (TextUtils.isEmpty(newDataId)) {
            Toast.makeText(this,"请先添加",Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("d1", "ADD" + System.currentTimeMillis() + "");
        contentValues.put("d2", "update" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        getContentResolver().update(selfContentUri,contentValues,"id=?",new String[]{newDataId});
    }

    private void queryData() {
        msgTv.setText("");
        Cursor cursor = getContentResolver().query(selfContentUri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String d1 = cursor.getString(cursor.getColumnIndex("d1"));
                String d2 = cursor.getString(cursor.getColumnIndex("d2"));
                contentTv.setText(contentTv.getText().toString() + "\n" + "d1=" + d1 + ": d2=" + d2);
            }
        }
    }
}
