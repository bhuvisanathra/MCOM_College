package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class emiActivity extends AppCompatActivity {

    Button calculate_emi;
    EditText Loan_Amnt,NoOfYear,Interest;
    TextView ForResult;
    Float disp_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        calculate_emi=findViewById(R.id.calc_emi);
        Loan_Amnt=findViewById(R.id.edit_LoanAmt);
        NoOfYear=findViewById(R.id.edit_NoOfYear);
        Interest=findViewById(R.id.edit_Interest);
        ForResult=findViewById(R.id.forResult);

        calculate_emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Loan_Amnt.getText().toString().isEmpty() && !NoOfYear.getText().toString().isEmpty() && !Interest.getText().toString().isEmpty()) {
                    int loan = Integer.parseInt(Loan_Amnt.getText().toString());
                    int year = Integer.parseInt(NoOfYear.getText().toString());
                    float interest1 = Float.parseFloat(Interest.getText().toString());

                    disp_result = (loan * (1 + (interest1 * year))) / (year * 12);
                    /* 10000 * (1 + 5 * 2) / (2 * 12) = 4583.3335 */
                    ForResult.setText(getString(R.string.result1) + disp_result);
                }
                else{
                    String str = getString(R.string.s2);
                    Toast.makeText(getApplicationContext(), str , Toast.LENGTH_SHORT).show();
                }
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
        if (item.getItemId()== R.id.emi_menu1)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.emi1);
            alertDialogBuilder.setMessage(R.string.emi2);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton(R.string.emi3, new DialogInterface.OnClickListener() {

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