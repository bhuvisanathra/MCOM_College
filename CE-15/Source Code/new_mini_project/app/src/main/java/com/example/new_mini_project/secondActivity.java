package com.example.new_mini_project;
 import android.os.Bundle;
 import androidx.appcompat.app.AppCompatActivity;
 import android.widget.TextView;

     public class secondActivity extends AppCompatActivity {

              DatabaseHandler db;
      TextView textView;
      String data;

              @Override
       protected void onCreate(Bundle savedInstanceState) {
                  super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_second);

                   textView= findViewById(R.id.viewSavedData);
                  db = new DatabaseHandler(this);

                   data = db.getEmployee();
                   textView.setText(data);

               }
   }