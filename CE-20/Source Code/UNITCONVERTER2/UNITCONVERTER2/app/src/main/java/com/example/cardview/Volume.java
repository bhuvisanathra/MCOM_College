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

public class Volume extends AppCompatActivity {

    public static Volume.UnitConverter UnitConverter;
    Spinner spinner1;
    Spinner spinner;
    EditText Text1;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        Text1 = findViewById(R.id.Text1);
        view = findViewById(R.id.view);

        Button btn2 = (Button) findViewById(R.id.btn1);

        //spinner first
        String[] length = {"kL", "L", "mL"};
        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length);
        spinner1 =
                (Spinner) findViewById(R.id.firstSpinner);
        spinner1.setAdapter(stringArrayAdapter);

        //spinner first

        //spinner second
        String[] length1 = {"kL", "L", "mL"};
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
        }
        else {
            double value = new Double(Text1.getText().toString());
            double ans = 0.0;
            String first = spinner1.getSelectedItem().toString();
            String second = spinner.getSelectedItem().toString();
            Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
            if (first.equals("kL")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "L":
                        ans = Volume.UnitConverter.kilolitreTolitre(value);
                        break;
                    case "mL":
                        ans = Volume.UnitConverter.kilolitreTomillilitre(value);
                        break;

                }
            }
            if (first.equals("L")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "mL":
                        ans = Volume.UnitConverter.litreTomillilitre(value);
                        break;
                    case "kL":
                        ans = Volume.UnitConverter.litreTokilolitre(value);
                        break;

                }
            }
            if (first.equals("mL")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "kL":
                        ans = Volume.UnitConverter.millilitreTokilolitre(value);
                        break;
                    case "L":
                        ans = Volume.UnitConverter.millilitreTolitre(value);
                        break;

                }
            }

            view.setText("Value is " + ans);
        }
    }

    private static class UnitConverter {
        //volume conversion
        public static double kilolitreTolitre(double f) { return f * 1000; }
        public static double kilolitreTomillilitre(double f) { return f * 1000000; }
        public static double litreTokilolitre(double f) {return f * 0.001; }
        public static double litreTomillilitre(double f) { return f * 1000; }
        public static double millilitreTolitre(double f) { return f * 0.001; }
        public static double  millilitreTokilolitre(double f) { return f /1000; }
        public static double kilolitreTokilolitre(double value) { return 0; }
        //volume conversion
    }
}