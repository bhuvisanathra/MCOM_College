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

public class Current extends AppCompatActivity {

    public static Current.UnitConverter UnitConverter;
    Spinner spinner1;
    Spinner spinner;
    EditText Text1;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        Text1 = findViewById(R.id.Text1);
        view = findViewById(R.id.view);

        Button btn2 = (Button) findViewById(R.id.btn1);

        //spinner first
        String[] length = {"Ampere", "KiloAmpere"};
        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length);
        spinner1 =
                (Spinner) findViewById(R.id.firstSpinner);
        spinner1.setAdapter(stringArrayAdapter);

        //spinner first

        //spinner second
        String[] length1 = {"Ampere", "KiloAmpere"};
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
            if (first.equals("Ampere")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "KiloAmpere":
                        ans = Current.UnitConverter.AmpereToKiloAmpere(value);
                        break;
                }
            }
            if (first.equals("KiloAmpere")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "Ampere":
                        ans = Current.UnitConverter.KiloAmpereToAmpere(value);
                        break;
                }
            }
            view.setText("Value is " + ans);

        }
    }
    protected static class UnitConverter {
        //Current conversion
        public static double AmpereToKiloAmpere(double f) { return f / 1000; }
        public static double KiloAmpereToAmpere(double f) { return f * 1000; }
        public static double AmpereToAmpere(double value) { return 0; }
        //Current  conversion
    }
}