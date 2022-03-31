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

public class bmiActivity extends AppCompatActivity {
    TextView BMI;
    Button calculate_BMI;
    EditText weight,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        BMI = findViewById(R.id.textView6);
        calculate_BMI = findViewById(R.id.btn_BMI);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        calculate_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!weight.getText().toString().isEmpty() && !height.getText().toString().isEmpty())
                        calculateBMI();
                else {
                    String str = getString(R.string.s3);
                    Toast.makeText(getApplicationContext(), str , Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void calculateBMI()
    {
        String heightStr = height.getText().toString();
        String weigtStr = weight.getText().toString();

        float heightValue = Float.parseFloat(heightStr) / 100;
        float weightValue = Float.parseFloat((weigtStr));

        float bmi = weightValue / (heightValue * heightValue);
        /* 50 / (1.5*1.5) = 22.22221*/

        displayBMI(bmi);
    }

    private void displayBMI(float bmi){
        String bmiLabel = "";

        if (Float.compare(bmi,15f) <= 0)
        {
            bmiLabel =getString(R.string.b1);
        }
        else if ((Float.compare(bmi, 15f) > 0) && Float.compare(bmi, 16f) <= 0)
        {
            bmiLabel =getString(R.string.b2);
        }
        else if ((Float.compare(bmi, 16f) > 0) && Float.compare(bmi, 18.5f) <= 0)
        {
            bmiLabel =getString(R.string.b3);
        }
        else if ((Float.compare(bmi, 18.5f) > 0) && Float.compare(bmi, 25f) <= 0)
        {
            bmiLabel =getString(R.string.b4);
        }
        else if ((Float.compare(bmi, 25f) > 0) && Float.compare(bmi, 30) <= 0)
        {
            bmiLabel =getString(R.string.b5);
        }
        else if ((Float.compare(bmi, 30f) > 0) && Float.compare(bmi, 35f) <= 0)
        {
            bmiLabel =getString(R.string.b6);
        }
        else if ((Float.compare(bmi, 35f) > 0) && Float.compare(bmi, 40f) <= 0)
        {
            bmiLabel =getString(R.string.b7);
        }
        else {
            bmiLabel =getString(R.string.b8);
        }
        bmiLabel = bmi + "\n" +bmiLabel;
        BMI.setText(bmiLabel);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.emi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.emi_menu1)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.bmi1);
            alertDialogBuilder.setMessage(R.string.bmi2);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton(R.string.bmi3, new DialogInterface.OnClickListener() {

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