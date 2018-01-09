package com.example.student.db2018010901;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 2018/1/9.
 */

public class MyHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "student.sqlite";
    static final int VERSION = 1;
    public MyHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE \"phone\" ( `_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `name` TEXT, `score` INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
