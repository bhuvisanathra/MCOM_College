package com.example.new_mini_project;

import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseHandler extends SQLiteOpenHelper {

                private static final int DATABASE_VERssSION = 1;
       private static final String DATABASE_NAME = "employee1";
       private static final String TABLE_EMPLOYEE = "employee";
       private static final String KEY_id = "Number";
       private static final String KEY_NAME = "Name";
       private static final String KEY_Number = "Email";
       private static final String KEY_CITY = "City";
    private static final int DATABASE_VERSION = DATABASE_VERssSION;

    SQLiteDatabase db;

               public DatabaseHandler(Context context) {
                   super(context, DATABASE_NAME, null, DATABASE_VERSION);
                   //3rd argument to be passed is CursorFactory instance
              }

               // Creating Tables
               @Override
       public void onCreate(SQLiteDatabase db) {
                   String query = "CREATE TABLE " + TABLE_EMPLOYEE + "("
                           + KEY_id + " INTEGER UNIQUE," + KEY_NAME + " TEXT,"
                           + KEY_Number + " TEXT,"
                           + KEY_CITY + " TEXT " + ")";
                   db.execSQL(query);
               }

               // Upgrading database
                // @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                   // Drop older table if existed
                   db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);

                   // Create tables again
                   onCreate(db);
               }

               // code to add the new employee
               public long addEmployee(String Name, String Email, String City) {
                   db = this.getWritableDatabase();

                   ContentValues values = new ContentValues();
                   values.put(KEY_NAME, Name); // Employee Name
                   values.put(KEY_Number, Email); // Employee Email
                   values.put(KEY_CITY, City); // Employee City

                   return db.insert(TABLE_EMPLOYEE, null, values);
               }

               // code to get the single employee
               public String getEmployee() {
                   db = this.getReadableDatabase();

                   Cursor cursor = db.query(TABLE_EMPLOYEE, new String[] {KEY_id,KEY_NAME,KEY_Number,KEY_CITY},
                                   null, null, null, null, null);

                   int eId = cursor.getColumnIndex(KEY_id);
                   int eName = cursor.getColumnIndex(KEY_NAME);
                   int eNumber = cursor.getColumnIndex(KEY_Number);
                   int eCity = cursor.getColumnIndex(KEY_CITY);

                   String res = "";

                   for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                           res = res +
                                           "ID: "+cursor.getString(eId)+"\n"+
                                           "Name: "+cursor.getString(eName)+"\n"+
                                           "Number: "+cursor.getString(eNumber)+"\n"+
                                           "City: "+cursor.getString(eCity)+"\n---------------------------------------\n";
                       }

                   db.close();
                   return res;
               }

               // code to update the single employee
               public void updateEmployee(long l, String Name, String Number, String City) {
                   db = this.getWritableDatabase();

                   ContentValues values = new ContentValues();
                   values.put(KEY_NAME, Name); // Employee Name
                   values.put(KEY_Number, Number); // Employee Age
                   values.put(KEY_CITY, City); // Employee City

                   db.update(TABLE_EMPLOYEE, values, KEY_id+"="+l,null);
                   db.close();

               }

               // Deleting single employee
               public void deleteEmployee(long l) {
                 db = this.getWritableDatabase();
                 db.delete(TABLE_EMPLOYEE, KEY_id + " ="+l,null);
               }

              public String getName(long l1){
                  db = this.getReadableDatabase();

                  Cursor cursor = db.query(TABLE_EMPLOYEE, new String[] {KEY_id,KEY_NAME,KEY_Number,KEY_CITY},
                                  KEY_id+"="+l1, null, null, null, null);

                  if (cursor != null) {
                          cursor.moveToFirst();
                          String name = cursor.getString(1);
                          return  name;
                      }
                  return null;
              }

              public String getAge(long l1){
                  db = this.getReadableDatabase();

                  Cursor cursor = db.query(TABLE_EMPLOYEE, new String[] {KEY_id,KEY_NAME,KEY_Number,KEY_CITY},
                                  KEY_id+"="+l1, null, null, null, null);

                  if (cursor != null) {
             cursor.moveToFirst();
                          String age = cursor.getString(2);
                          return  age;
                      }
                  return null;
              }
public String getCity(long l1){
                  db = this.getReadableDatabase();

                 Cursor cursor = db.query(TABLE_EMPLOYEE, new String[] {KEY_id,KEY_NAME,KEY_Number,KEY_CITY},
                                  KEY_id+"="+l1, null, null, null, null);

                  if (cursor != null) {
                          cursor.moveToFirst();
                          String city = cursor.getString(3);
                          return  city;
                      }
                  return null;
              }

          }