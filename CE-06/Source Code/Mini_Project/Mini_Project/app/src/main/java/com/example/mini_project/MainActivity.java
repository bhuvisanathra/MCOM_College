package com.example.mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    TextView tvCases, tvRecovered, tvCritical, tvActive,tvTotalDeaths, tvTodayDeaths;
    Spinner spinner;
    private ProgressDialog progDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progDialog = new ProgressDialog(this);
        progDialog.setTitle("Access data");
        progDialog.setMessage("Please wait...");
        progDialog.setCancelable(false);


        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        spinner = findViewById(R.id.spinner);
       //progDialog = findViewById(R.id.progressBar);

        this.fetcountry();
        this.fetchdata("");
    }

    private void  fetchdata(String countrySlug) {
        String url = "https://api.covid19api.com/summary";
         progDialog.show();

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url, new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                    progDialog.dismiss();

                        try {
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());


                            JSONObject globlDt = new JSONObject(jsonObject.getString("Global"));

                            if (countrySlug != "") {

                                JSONArray countryDt = new JSONArray(jsonObject.getString("Countries"));
                                for (int i = 0; i < countryDt.length(); i++) {
                                    String tmpSlug = countryDt.getJSONObject(i).getString("Country");
                                    if (tmpSlug.equals(countrySlug)) {

                                        globlDt = countryDt.getJSONObject(i);
                                        break;
                                    }
                                }
                            }

                            tvCases.setText(
                                    globlDt.getString("TotalConfirmed"));
                            tvCritical.setText(
                                    globlDt.getString("NewConfirmed"));
                            tvRecovered.setText(
                                    globlDt.getString("TotalRecovered"));
                            tvActive.setText(
                                    globlDt.getString("NewRecovered"));
                            tvTotalDeaths.setText(
                                    globlDt.getString("TotalDeaths"));
                            tvTodayDeaths.setText(
                                    globlDt.getString("NewDeaths"));
                        }
                        catch (JSONException e) {
                            Toast.makeText(MainActivity.this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }


                },
                new Response.ErrorListener() {
                    public void onErrorResponse(
                            VolleyError error)

                    {
                        Toast.makeText(MainActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

    public void  fetcountry() {
        String url1 = "https://api.covid19api.com/countries";
        StringRequest request2
                = new StringRequest(
                Request.Method.GET,
                url1, new Response.Listener() {

            @Override
            public void onResponse(Object response) {


                try {
                    JSONArray jsonObject
                            = new JSONArray(
                            response.toString());

                    List<String> codes = new ArrayList<String>();

                    codes.add("All");
                    for (int i = 0; i < jsonObject.length(); i++) {
                        codes.add(jsonObject.getJSONObject(i).getString("Country"));

                    }
                    ArrayAdapter<String> adapterTime = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, codes);
                    spinner.setAdapter(adapterTime);

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            try {

                                if (i == 0) {
                                    fetchdata("");
                                } else {
                                    String code = jsonObject.getJSONObject(i-1).getString("Country");
                                    
                                    Toast.makeText(MainActivity.this, "" + code, Toast.LENGTH_SHORT).show();
                                    fetchdata(code);
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });


                }
                catch (JSONException e) {
                    Toast.makeText(MainActivity.this,
                            e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }


        },
                new Response.ErrorListener() {
                    public void onErrorResponse(
                            VolleyError error)

                    {
                        Toast.makeText(MainActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue2
                = Volley.newRequestQueue(this);
        requestQueue2.add(request2);
    }


}