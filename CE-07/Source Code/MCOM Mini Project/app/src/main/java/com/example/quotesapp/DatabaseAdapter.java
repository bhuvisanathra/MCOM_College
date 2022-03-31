package com.example.quotesapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DatabaseAdapter {

    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    Context context;

    public DatabaseAdapter(Context context) {
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        this.context = context;
    }

    public SimpleCursorAdapter populateListViewFromDB(){
        String columns[] = {DatabaseHelper.KEY_ROWID, DatabaseHelper.KEY_QUOTE, DatabaseHelper.KEY_AUTHOR};
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        String[] fromFieldNames = new String[]{
                DatabaseHelper.KEY_ROWID, DatabaseHelper.KEY_QUOTE, DatabaseHelper.KEY_AUTHOR
        };
        int[] toViewIDs = new int[]{R.id.idTextView, R.id.quoteTextView, R.id.authorTextView};
        return new SimpleCursorAdapter(
                context,
                R.layout.list_item,
                cursor,
                fromFieldNames,
                toViewIDs
        );
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydb.db";
        private static final String TABLE_NAME = "quotes";
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_ROWID = "_id";
        private static final String KEY_QUOTE="quote";
        private static final String KEY_AUTHOR = "author";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+ " ("+ KEY_ROWID+" integer primary key autoincrement, "+ KEY_QUOTE + " text, "+ KEY_AUTHOR+ " text)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private final Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
