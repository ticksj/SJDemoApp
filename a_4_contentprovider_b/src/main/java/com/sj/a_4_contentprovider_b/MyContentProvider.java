package com.sj.a_4_contentprovider_b;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.sj.a_4_contentprovider_b.db.DBTables;
import com.sj.a_4_contentprovider_b.db.DBUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyContentProvider extends ContentProvider {
    private static final String TAG = "MyContentProvider";
    public static final int DATA_DIR = 0;
    public static final int DATA_ITEM = 1;

    private static UriMatcher uriMatcher;
    private static String AUTHORITY = "com.sj.a_4_contentprovider_b.provider";

    private static String PATH = "dtable";

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PATH, DATA_DIR);
        uriMatcher.addURI(AUTHORITY, PATH + "/#", DATA_ITEM);
    }


    @Override
    public boolean onCreate() {
        DBUtils.init(getContext());
        ContentValues contentValues = new ContentValues();
        contentValues.put("d1", "D1" + System.currentTimeMillis() + "");
        contentValues.put("d2", "D1" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DBUtils.insert(DBTables.D_TABLE, null, contentValues);
        contentValues.clear();
        contentValues.put("d1", "D2" + System.currentTimeMillis() + "");
        contentValues.put("d2", "D2" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DBUtils.insert(DBTables.D_TABLE, null, contentValues);
        contentValues.clear();
        contentValues.put("d1", "D3" + System.currentTimeMillis() + "");
        contentValues.put("d2", "D3" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DBUtils.insert(DBTables.D_TABLE, null, contentValues);
        contentValues.clear();
        contentValues.put("d1", "D4" + System.currentTimeMillis() + "");
        contentValues.put("d2", "D4" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        DBUtils.insert(DBTables.D_TABLE, null, contentValues);
        return true;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case DATA_DIR:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + PATH;
            case DATA_ITEM:
                return "vnd.android.cursor.item/" + AUTHORITY + "." + PATH;
            default:
                break;
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = DBUtils.insert(DBTables.D_TABLE, null, values);
        return Uri.parse("content://" + AUTHORITY + "/" + PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (uriMatcher.match(uri)) {
            case DATA_DIR:
                return DBUtils.delete(PATH, selection, selectionArgs);
            case DATA_ITEM:
                String dataId = uri.getPathSegments().get(1);
                return DBUtils.delete(PATH, "id=?", new String[]{dataId});
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        switch (uriMatcher.match(uri)) {
            case DATA_DIR:
                return DBUtils.update(PATH, values, selection, selectionArgs);
            case DATA_ITEM:
                String dataId = uri.getPathSegments().get(1);
                return DBUtils.update(PATH, values, "id=?", new String[]{dataId});
        }
        return 0;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.e(TAG, "query: " );
        switch (uriMatcher.match(uri)) {
            case DATA_DIR:
                return DBUtils.query(PATH, projection, selection, selectionArgs, null, null, sortOrder);
            case DATA_ITEM:
                String dataId = uri.getPathSegments().get(1);
                return DBUtils.query(PATH, projection, "id=?", new String[]{dataId}, null, null, sortOrder);
        }
        return null;
    }
}
