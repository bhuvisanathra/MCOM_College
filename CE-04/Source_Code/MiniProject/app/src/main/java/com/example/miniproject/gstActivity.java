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

public class gstActivity extends AppCompatActivity {
    TextView gstAmnt, netAmnt;
    EditText amnt, gstPer;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst);

        amnt = findViewById(R.id.editText1);
        gstPer = findViewById(R.id.editText2);
        calculate = findViewById(R.id.btn1);
        gstAmnt = findViewById(R.id.textView5);
        netAmnt = findViewById(R.id.textView6);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!amnt.getText().toString().isEmpty() && !gstPer.getText().toString().isEmpty()){
                    float total = Float.parseFloat(amnt.getText().toString());
                    float get_percent = Float.parseFloat(gstPer.getText().toString());
                    float gst_amount = Math.round(((get_percent / 100) * total));

                    gstAmnt.setText(getString(R.string.g1) + gst_amount);

                    float total_amount = total + gst_amount;
                    netAmnt.setText(getString(R.string.g2) + total_amount);
                }
                else {
                    String str = getString(R.string.s1);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

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
            alertDialogBuilder.setTitle(R.string.gst_1);
            alertDialogBuilder.setMessage(R.string.gst2);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton(R.string.gst3, new DialogInterface.OnClickListener() {

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