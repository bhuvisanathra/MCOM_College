package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button EMI, BMI, GST, sCalc, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EMI = findViewById(R.id.button);
        BMI = findViewById(R.id.button2);
        GST = findViewById(R.id.button3);
        sCalc = findViewById(R.id.button4);
        feedback = findViewById(R.id.button5);

        EMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emiI = new Intent(getApplicationContext(), emiActivity.class);
                startActivity(emiI);
            }
        });

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmiI = new Intent(getApplicationContext(), bmiActivity.class);
                startActivity(bmiI);
            }
        });
        GST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gstI = new Intent(getApplicationContext(), gstActivity.class);
                startActivity(gstI);
            }
        });
        sCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sCalc1 = new Intent(getApplicationContext(), Simple_Calc.class);
                startActivity(sCalc1);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(getApplicationContext(), feedbackActivity.class);
                startActivity(f);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.emi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.emi_menu1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.m1);
            alertDialogBuilder.setMessage(R.string.m2);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton(R.string.m3, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return true;
        }

        if(item.getItemId() == R.id.emi_menu2){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Choose Language !");
            String[] language = {"Hindi","English"};
            int checkedItem = 1;
            alertDialog.setSingleChoiceItems(language, checkedItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(which == 0){
                        setLocale("hi");
                        recreate();
                    }
                    else if(which == 1){
                        setLocale("en");
                        recreate();
                    }
                    alertDialog.create();
                    alertDialog.show();

                }

                private void setLocale(String language) {
                    Locale locale = new Locale(language);
                    Locale.setDefault(locale);

                    Configuration configuration = new Configuration();
                    configuration.locale = locale;
                    getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources()
                            .getDisplayMetrics());
                }
            });

            AlertDialog alert = alertDialog.create();
            alert.setCanceledOnTouchOutside(false);
            alert.show();
        }
        return true;
    }
}


