package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Simple_Calc extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3,b4;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);

        e1 = findViewById(R.id.no1);
        e2 = findViewById(R.id.no2);
        b1 = findViewById(R.id.plus);
        b2 = findViewById(R.id.minus);
        b3 = findViewById(R.id.multiply);
        b4 = findViewById(R.id.divide);
        t1 = findViewById(R.id.result);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()) {
                        int n1 = Integer.parseInt(e1.getText().toString());
                        int n2 = Integer.parseInt(e2.getText().toString());

                        int sum = n1 + n2;
                        t1.setText("= " + sum);
                    }
                    else{
                        String str = getString(R.string.s9);
                        Toast.makeText(getApplicationContext(),str , Toast.LENGTH_SHORT).show();
                    }
                }
            });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()){
                    int n1 = Integer.parseInt(e1.getText().toString());
                    int n2 = Integer.parseInt(e2.getText().toString());

                    int minus = n1 - n2;

                    t1.setText("= "+minus);
                }
                else{
                    String str = getString(R.string.s8);
                    Toast.makeText(getApplicationContext(),str , Toast.LENGTH_SHORT).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()){
                    int n1 = Integer.parseInt(e1.getText().toString());
                    int n2 = Integer.parseInt(e2.getText().toString());

                    int multiplication = n1 * n2;
                    t1.setText("= "+multiplication);
                }
                else{
                    String str = getString(R.string.s5);
                    Toast.makeText(getApplicationContext(),str , Toast.LENGTH_SHORT).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()){
                    int n1 = Integer.parseInt(e1.getText().toString());
                    int n2 = Integer.parseInt(e2.getText().toString());
                try {
                    int division = n1 / n2;
                    t1.setText("= "+division);
                }
                catch(Exception e){
                    String str = getString(R.string.s6);
                    Toast.makeText(getApplicationContext(), str , Toast.LENGTH_SHORT).show();
                }

                }
               else{
                   String str = getString(R.string.s7);
                    Toast.makeText(getApplicationContext(),str , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.emi_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.emi_menu1)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.s_1);
            alertDialogBuilder.setMessage(R.string.s_2);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton(R.string.s_3, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        return true;
    }

}