package com.sj.base_database.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SJ on 2018/11/5.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBTables.DB_NAME, null, DBTables.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBTables.ACCOUNT_SQL);
        db.execSQL(DBTables.ACCOUNT_SORT_SQL);
        db.execSQL(DBTables.ACCOUNT_DETAIL_SQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
