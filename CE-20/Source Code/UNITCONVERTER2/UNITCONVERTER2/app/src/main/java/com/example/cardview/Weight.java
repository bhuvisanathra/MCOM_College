package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Weight extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner;
    EditText Text1;
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Text1=findViewById(R.id.Text1);
        view=findViewById(R.id.view);

        Button btn2 = (Button) findViewById(R.id.btn1);

        //spinner first
        String[] length={"t", "kg","g","mg"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length);
        spinner1 =
                (Spinner)  findViewById(R.id.firstSpinner);
        spinner1.setAdapter(stringArrayAdapter);

        //spinner first

        //spinner second
        String[] length1={"t", "kg","g","mg"};
        ArrayAdapter<String> stringArrayAdapter1=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length1);
        spinner =
                (Spinner)  findViewById(R.id.secondSpinner);
        spinner.setAdapter(stringArrayAdapter1);

        //spinner second

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String NewItem = length.toString();




            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void convertTo(View v) {
        if (TextUtils.isEmpty(Text1.getText().toString())) {
            Toast.makeText(this, "Please Enter Number ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            double value = new Double(Text1.getText().toString());
            double ans = 0.0;
            String first = spinner1.getSelectedItem().toString();
            String second = spinner.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
            if (first.equals("t")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "kg":
                        ans = Weight.UnitConverter.tonneTokilogram(value);
                        break;
                    case "g":
                        ans = Weight.UnitConverter.tonneTogram(value);
                        break;
                    case "mg":
                        ans = Weight.UnitConverter.tonneTomiligram(value);
                        break;
                }
            }
            if (first.equals("kg")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "g":
                        ans = Weight.UnitConverter.kilogramTogram(value);
                        break;
                    case "mg":
                        ans = Weight.UnitConverter.kilogramTomiligram(value);
                        break;
                    case "t":
                        ans = Weight.UnitConverter.kilogramTotonne(value);
                        break;
                }
            }
            if (first.equals("g")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "mg":
                        ans = Weight.UnitConverter.gramTomiligram(value);
                        break;
                    case "t":
                        ans = Weight.UnitConverter.gramTtonne(value);
                        break;
                    case "kg":
                        ans = Weight.UnitConverter.gramTokilogram(value);
                        break;
                }
            }
            if (first.equals("mg")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "t":
                        ans = Weight.UnitConverter.miligramTtonne(value);
                        break;
                    case "kg":
                        ans = Weight.UnitConverter.miligramTkilogram(value);
                        break;
                    case "g":
                        ans = Weight.UnitConverter.miligramTgram(value);
                        break;

                }
            }

            view.setText("Value is " + ans);
        }
    }
    public static class UnitConverter {
        //Weight conversion
        public static double tonneTokilogram(double f){return f*1000;}
        public static double tonneTogram(double f){return f*1000000;}
        public static double tonneTomiligram(double f){return f*1000000000;}
        public static double kilogramTogram(double f){return f*1000;}
        public static double kilogramTomiligram(double f){
            return f*1000000;
        }
        public static double kilogramTotonne(double f){
            return f*0.001;
        }
        public static double gramTomiligram(double f){
            return f*1000;
        }
        public static double gramTokilogram(double y){ return y*0.001; }
        public static double gramTtonne(double y){ return y*0.000001;}
        public static double miligramTtonne(double y){ return y*1.E-9;}
        public static double miligramTkilogram(double y){ return y*0.000001;}
        public static double miligramTgram(double y){ return y*0.001;}

        //weight conversion
        public static double tonneTotonne(double value) {
            return 0;
        }
    }
}