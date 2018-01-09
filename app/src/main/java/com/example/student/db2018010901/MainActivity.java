package com.example.student.db2018010901;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void copyFile(File dbFile)
    {
        if (!dbFile.exists())
        {
            try {
                InputStream is = getResources().openRawResource(R.raw.students);
                OutputStream os = new FileOutputStream(dbFile);
                byte b[] = new byte[1024];
                int length;
                while ((length = is.read(b)) != -1)
                {
                    os.write(b, 0, length);
                }
                os.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void click1(View v)
    {
        // copyFile(dbFile);
        // SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
        MyHelper helper = new MyHelper(MainActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query("phone", new String[] {"_id", "name", "score"},
                null, null, null, null, null);
        if (c.moveToFirst()){
            Log.d("DATA", c.getString(1));
            while(c.moveToNext())
            {
                Log.d("DATA", c.getString(1));
            }
        }


        c.close();
        db.close();
    }
    public void click2(View v)
    {
        MyHelper helper = new MyHelper(MainActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", "Bob");
        cv.put("score", 99);
        db.insert("phone", null, cv);
    }
}
