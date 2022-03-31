package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class feedbackActivity extends AppCompatActivity {
    String feedback1;
    EditText fidback;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        fidback = findViewById(R.id.feedback);
        btn2 = findViewById(R.id.insertF);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick (View view){
                if(!fidback.getText().toString().isEmpty())
                {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.f1) + fidback.getText().toString());
                intent.setType("text/plain");
                startActivity(intent);
                }
                else{
                    String str = getString(R.string.f11);
                    Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}