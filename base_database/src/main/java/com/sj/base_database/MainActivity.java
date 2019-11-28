package com.sj.base_database;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.base_database.base.DBTables;
import com.sj.base_database.base.DBUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBaseData();
    }

    private void initBaseData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "日常消费");
        contentValues.put("details", "饮食#水果#衣物");
        DBUtils.insert(DBTables.TABLE_ACCOUNT_SORT, null, contentValues);
        contentValues.clear();
        contentValues.put("details", "饮食#水果#衣物#交通");
        DBUtils.update(DBTables.TABLE_ACCOUNT_SORT, contentValues, "name = ?", new String[]{"日常消费"});
        Cursor cursor = DBUtils.query(DBTables.TABLE_ACCOUNT_SORT, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String details = cursor.getString(cursor.getColumnIndex("details"));
                Log.e(TAG, "name: " + name);
                Log.e(TAG, "details: " + details);
            } while (cursor.moveToNext());
            cursor.close();
        }
        DBUtils.delete(DBTables.TABLE_ACCOUNT_SORT, "name = ?", new String[]{"日常消费"});
    }
}
