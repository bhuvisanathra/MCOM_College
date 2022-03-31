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

public class Area extends AppCompatActivity {

    public static Area.UnitConverter UnitConverter;
    Spinner spinner1;
    Spinner spinner;
    EditText Text1;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        Text1 = findViewById(R.id.Text1);
        view = findViewById(R.id.view);

        Button btn2 = (Button) findViewById(R.id.btn1);

        //spinner first
        String[] length = {"hectare", "square foot", "square meter","Acre"};
        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        length);
        spinner1 =
                (Spinner) findViewById(R.id.firstSpinner);
        spinner1.setAdapter(stringArrayAdapter);

        //spinner first

        //spinner second
        String[] length1 = {"hectare", "square foot", "square meter","Acre"};
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
            if (first.equals("hectare")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "square foot":
                        ans = Area.UnitConverter.HectareTosquarefoot(value);
                        break;
                    case "square meter":
                        ans = Area.UnitConverter.HectareTosquaremeter(value);
                        break;
                    case "Acre":
                        ans = Area.UnitConverter.HectareToAcre(value);
                        break;
                }
            }
            if (first.equals("square foot")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "hectare":
                        ans = Area.UnitConverter.squarefootToHectare(value);
                        break;
                    case "square meter":
                        ans = Area.UnitConverter.squarefootTosquaremeter(value);
                        break;
                    case "Acre":
                        ans = Area.UnitConverter.squarefootToAcre(value);
                        break;


                }
            }
            if (first.equals("Acre")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "hectare":
                        ans = Area.UnitConverter.AcreToHectare(value);
                        break;
                    case "square meter":
                        ans = Area.UnitConverter.AcreTosquaremeter(value);
                        break;
                    case "square foot":
                        ans = Area.UnitConverter.AcreTosquarefoot(value);
                        break;


                }
            }
            if (first.equals("Square meter")) {
                Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
                switch (second) {
                    case "hectare":
                        ans = Area.UnitConverter.squaremeterToHectare(value);
                        break;
                    case "Acre":
                        ans = Area.UnitConverter.squaremeterToAcre(value);
                        break;
                    case "Square foot":
                        ans = Area.UnitConverter.squaremeterTosquarefoot(value);
                        break;
                }
            }


            view.setText("Value is " + ans);

        }
    }
    protected static class UnitConverter {
        //Area conversion
        public static double HectareTosquarefoot(double f) {
            return f * 107639;
        }
        public static double HectareTosquaremeter(double f) {
            return f * 10000;
        }
        public static double HectareToAcre(double f) {
            return f * 2.47105;
        }
        public static double squarefootToHectare(double f) { return f * 2.471; }
        public static double squarefootTosquaremeter(double f) { return f * 0.092903; }
        public static double squarefootToAcre(double f) { return f * 2.2957e-5; }
        public static double AcreTosquarefoot(double f) { return f * 43560; }
        public static double AcreTosquaremeter(double f) { return f * 4046.86; }
        public static double AcreToHectare(double f) { return f * 0.404686; }
        public static double squaremeterToAcre(double f) { return f * 0.000247105; }
        public static double squaremeterTosquarefoot(double f) { return f * 10.764; }
        public static double squaremeterToHectare(double f) { return f * 0.0001; }

        public static double HectareToHectare(double value) { return 0; }
        //Area conversion



    }
}