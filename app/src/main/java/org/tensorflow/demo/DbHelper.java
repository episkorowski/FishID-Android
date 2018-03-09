package org.tensorflow.demo;

/**
 * Created by Eric on 3/4/2018.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "fish.db";
    private static final int DB_VERSION = 2;
    private static String TAG = "DatabaseHelper";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        setForcedUpgrade();
    }

    public ArrayList<HashMap<String,String>> getAllFish() {
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> item;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM FISH_LIST ORDER BY NAME", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            item = new HashMap<String,String>();
            Log.d(TAG, cursor.getString(0) + cursor.getString(1) + cursor.getString(2));
            item.put("line1", cursor.getString(1));
            item.put("line2", cursor.getString(2));
            list.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


}
