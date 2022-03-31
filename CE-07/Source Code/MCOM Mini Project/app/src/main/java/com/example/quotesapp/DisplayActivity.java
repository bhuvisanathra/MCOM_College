package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);

        ListView listView = findViewById(R.id.listView);
        final SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDB();
        listView.setAdapter(simpleCursorAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
            String name = cursor.getString(1);
            Toast.makeText(DisplayActivity.this, name, Toast.LENGTH_LONG).show();
        });
    }
}