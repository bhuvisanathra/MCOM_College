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

import static android.text.TextUtils.isEmpty;

public class Length extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner;
    EditText Text1;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        Text1 = findViewById(R.id.Text1);
        view = findViewById(R.id.view);

        Button btn2 = (Button) findViewById(R.id.btn1);

        //spinner first
        String[] length = {"Feet", "Meter", "Kilometer", "cm", "Miles", "Yards"};
        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length);
        spinner1 = (Spinner) findViewById(R.id.firstSpinner);
        spinner1.setAdapter(stringArrayAdapter);

        //spinner first

        //spinner second
        String[] length1 = {"Feet", "Meter", "Kilometer", "cm", "Miles", "Yards"};
        ArrayAdapter<String> stringArrayAdapter1 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length1);
        spinner =
                (Spinner) findViewById(R.id.secondSpinner);
        spinner.setAdapter(stringArrayAdapter1);

        //spinner second

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String NewItem = length.toString();


                //  Toast.makeText(getApplicationContext(),"You Selected: "+length,Toast.LENGTH_LONG).show();

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void convertTo(View v) {
        if (TextUtils.isEmpty(Text1.getText().toString())) {
            Toast.makeText(getApplicationContext(),"Please Enter Number ", Toast.LENGTH_SHORT).show();

            return;
        } else {
            double value = new Double(Text1.getText().toString());
            double ans = 0.0;
            String first = spinner1.getSelectedItem().toString();
            String second = spinner.getSelectedItem().toString();

            Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();

            if (first.equals("Feet")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Meter":
                        ans = UnitConverter.feetToMeters(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.feetToMiles(value);
                        break;
                    case "Yards":
                        ans = UnitConverter.feetToYards(value);
                        break;
                    case "cm":
                        ans = UnitConverter.feetTocm(value);
                        break;
                    case "Kilometer":
                        ans = UnitConverter.feetTokilometer(value);
                        break;
                }
            }
            if (first.equals("Meter")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.metersToFeet(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.metersToMiles(value);
                        break;
                    case "Yards":
                        ans = UnitConverter.metersToYards(value);
                        break;
                    case "cm":
                        ans = UnitConverter.metersTocm(value);
                        break;

                    case "Kilometer":
                        ans = UnitConverter.metersToKilometer(value);
                        break;

                }
            }
            if (first.equals("Miles")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.milesToFeet(value);
                        break;
                    case "Meter":
                        ans = UnitConverter.milesToMeters(value);
                        break;
                    case "Yards":
                        ans = UnitConverter.milesToYards(value);
                        break;

                    case "cm":
                        ans = UnitConverter.milesTocentimeter(value);
                        break;
                }
            }
            if (first.equals("Yards")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.yardsToFeet(value);
                        break;
                    case "Meter":
                        ans = UnitConverter.yardsToMeters(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.yardsToMiles(value);
                        break;
                    case "Kilometer":
                        ans = UnitConverter.yardsToMiles(value);
                        break;
                    case "cm":
                        ans = UnitConverter.yardsTocentimeter(value);
                        break;
                }
            }
            if (first.equals("Kilometer")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.kilometerTofeet(value);
                        break;
                    case "Meter":
                        ans = UnitConverter.kilometerToMeters(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.kilometerToMiles(value);
                        break;
                    case "cm":
                        ans = UnitConverter.kilometerToCentimeter(value);
                        break;
                    case "Yards":
                        ans = UnitConverter.kilometerToyards(value);
                        break;
                }
            }
            if (first.equals("cm")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.CentimeterTofeet(value);
                        break;
                    case "Meter":
                        ans = UnitConverter.CentimeterToMeters(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.CentimeterToMiles(value);
                        break;
                    case "Kilometer":
                        ans = UnitConverter.CentimeterToMeters(value);
                        break;
                }
            }
            if (first.equals("Meter")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Feet":
                        ans = UnitConverter.metersToFeet(value);
                        break;
                    case "cm":
                        ans = UnitConverter.metersToCentimeter(value);
                        break;
                    case "Miles":
                        ans = UnitConverter.metersToMiles(value);
                        break;
                    case "Kilometer":
                        ans = UnitConverter.metersTokliometer(value);
                        break;
                }
            }
            view.setText("Value is " + ans);
        }
    }






    public static class UnitConverter {
        //length conversion
        public static double metersToCentimeter(double f){return f*100;}
        public static double CentimeterToMeters(double f){return f*0.01;}
        public static double CentimeterToMiles(double f){return f/160934;}
        public static double CentimeterTofeet(double f){return f/30.48;}
        public static double kilometerToCentimeter(double f){return f*100000;}
        public static double kilometerTofeet(double f){return f*3280.84;}
        public static double kilometerToMiles(double f){return f/1.609;}
        public static double kilometerToMeters(double f){return f*1000;}
        public static double kilometerToyards(double f){return f*1094;}
        public static double feetToMeters(double f){return f*0.3058; }
        public static double feetTokilometer(double f){return f/3281; }
        public static double feetToYards(double f){ return f*0.333333; }
        public static double feetToMiles(double f){ return f*0.000189394; }
        public static double feetTocm(double f){ return f*30.48; }
        public static double yardsToFeet(double y){ return y/0.333333; }
        public static double yardsToYards(double y){ return y; }
        public static double yardsToMeters(double y){ return y*0.9144; }
        public static double yardsTocentimeter(double y){ return y*91.44; }
        public static double yardsToMiles(double y){ return y*0.000568182; }
        public static double metersToFeet(double m){ return m*3.28084; }
        public static double metersToYards(double m){ return m*1.09361; }
        public static double metersTocm(double m){ return m*100; }
        public static double metersToMiles(double m){ return m/1609; }
        public static double metersToKilometer(double m){ return m/1000; }
        public static double metersToMeters(double m){ return m; }
        public static double metersTokliometer(double m){ return m/1000; }
        public static double milesToFeet(double miles){
            return miles*5280;
        }
        public static double milesToYards(double miles){
            return miles*1760;
        }
        public static double milesToMeters(double miles){
            return miles*1609.34;
        }
        public static double milesTokilometer(double miles){
            return miles*1.609;
        }
        public static double milesTocentimeter(double miles){
            return miles*160934;
        }

        public static double milesToMiles(double miles){
            return miles;
        }
        //length conversion
        public static double feetToFeet(double value) {
            return 0;
        }
    }
}