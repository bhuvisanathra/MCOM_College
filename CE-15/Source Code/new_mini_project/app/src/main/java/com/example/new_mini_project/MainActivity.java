package com.example.new_mini_project;

import android.content.Intent;
    import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
    import android.widget.Button;
   import android.widget.EditText;
    import android.widget.Toast;

           import androidx.appcompat.app.AppCompatActivity;

           public class MainActivity extends AppCompatActivity implements View.OnClickListener {

               DatabaseHandler db;

               EditText eNumber, eName, eEmail,eCity;
       Button bSave,bView,bUpdate,bDelete,bSearch;

       String Number,Id;
       String Name;
       String Email;
       String City;

               @Override
       protected void onCreate(Bundle savedInstanceState) {
                   super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_main);

                   eNumber = findViewById(R.id.Number);
                   eName = findViewById(R.id.Name);
                   eEmail = findViewById(R.id.Email);
                   eCity = findViewById(R.id.City);

                   bSave = findViewById(R.id.save);
                   bView = findViewById(R.id.view);
                   bUpdate = findViewById(R.id.update);
                   bDelete = findViewById(R.id.delete);
                   bSearch = findViewById(R.id.search);

                   bSave.setOnClickListener(this);
                   bView.setOnClickListener(this);
                   bUpdate.setOnClickListener(this);
                   bDelete.setOnClickListener(this);
                   bSearch.setOnClickListener(this);

                   db = new DatabaseHandler(this);

               }

               @Override
       public void onClick(View v) {
                   switch (v.getId()){

                           case R.id.save:
                                   Name = eName.getText().toString();

                                   Email = eEmail.getText().toString();
                                   City = eCity.getText().toString();

                                   if(Name.equals("") | Email.equals("") | City.equals("")){
                                           Toast.makeText(this,"Please fill the fields.", Toast.LENGTH_SHORT).show();
                                       }else{
                                           db.addEmployee(Name, Email,City);
                                           eNumber.setText("");
                                           eName.setText("");
                                           eEmail.setText("");
                                           eCity.setText("");
                                           Toast.makeText(this,"Data saved successfully.", Toast.LENGTH_SHORT).show();
                                       }
                                   break;

                           case R.id.view:
                                   String data = db.getEmployee();

                                   if (data.equals("")){
                                           Toast.makeText(this,"No data found.", Toast.LENGTH_SHORT).show();
                                       }else {
                                           Intent intent = new Intent(this, secondActivity.class);
                                           startActivity(intent);
                                       }
                                   break;

                           case R.id.update:
                                   Id = eNumber.getText().toString().trim();
                                   Name = eName.getText().toString().trim();
                                   Email = eEmail.getText().toString();
                                   City = eCity.getText().toString();

                                   if(Id.equals("") | Name.equals("") | Email.equals("") | City.equals("")){
                                       Toast.makeText(this,"Please fill all the fields .", Toast.LENGTH_SHORT).show();
                                       }else{
                                           long l = Long.parseLong(Id);
                                           db.updateEmployee(l,Name,Email,City);
                                           eNumber.setText("");
                                           eName.setText("");
                                           eEmail.setText("");
                                           eCity.setText("");
                                           Toast.makeText(this,"Data updated successfully.", Toast.LENGTH_SHORT).show();
                                       }
                                  break;

                          case R.id.delete:
                                  Number = eNumber.getText().toString();

                                  if(Number.equals("")){
                                          Toast.makeText(this,"Please fill the ID.", Toast.LENGTH_SHORT).show();
                                      }else{
                                          long l = Long.parseLong(Number);
                                          db.deleteEmployee(l);
                                          eNumber.setText("");
                                          eName.setText("");
                                          eEmail.setText("");
                                          eCity.setText("");
                                          Toast.makeText(this,"Data deleted successfully.", Toast.LENGTH_SHORT).show();
                                      }
                                  break;

                          case R.id.search:
                                  Number = eNumber.getText().toString().trim();

                                  if(Number.equals("")){
                                          Toast.makeText(this,"Please fill the ID.", Toast.LENGTH_SHORT).show();
                                      }else{
                                          try {
                                                  long l1 = Long.parseLong(Number);
                                                  Name = db.getName(l1);
                                                  Email = db.getAge(l1);
                                                  City = db.getCity(l1);

                                                  eName.setText(Name);
                                                  eEmail.setText(Email);
                                                  eCity.setText(City);

                                                  Toast.makeText(this,"Data found successfully.", Toast.LENGTH_SHORT).show();

                                              }catch (Exception e){
                                                  Toast.makeText(this,"Number is not valid.", Toast.LENGTH_SHORT).show();
                                              }

                                      }
                                  break;
                      }
              }
  }