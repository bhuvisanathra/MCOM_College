package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;

public class Adapter {
    DbCon dbCon;
    SQLiteDatabase sqLiteDatabase;
    Context context;

    public Adapter(Context context)
    {
        this.context=context;
        dbCon = new DbCon(context);
    }
    public Adapter open() throws Exception
    {
        sqLiteDatabase = dbCon.getWritableDatabase();
        return this;
    }
    public void close() throws Exception
    {
        sqLiteDatabase.close();
    }
    public long insert(String feedback1) throws Exception
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put("feedback1",feedback1);
        long l1 = sqLiteDatabase.insert("feedback",null,contentValues);
        return l1;
    }
}
