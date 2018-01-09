package com.example.student.db2018010901;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                if ((length = is.read(b)) != -1)
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
        File dbFile = new File(getFilesDir() + File.separator + "students.db");
        copyFile(dbFile);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
    }
}
