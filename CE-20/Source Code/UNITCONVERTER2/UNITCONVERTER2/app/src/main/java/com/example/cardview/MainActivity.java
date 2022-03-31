package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = (CardView) findViewById(R.id.l1);
        card2 = (CardView) findViewById(R.id.t1);
        card3 = (CardView) findViewById(R.id.k1);
        card4 = (CardView) findViewById(R.id.a1);
        card5 = (CardView) findViewById(R.id.v1);
        card6 = (CardView) findViewById(R.id.c1);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.l1:
                i = new Intent(this,Length.class);
                startActivity(i);
                break;

            case R.id.t1:
                i = new Intent(this,Temprature.class);
                startActivity(i);
                break;

            case R.id.k1:
                i = new Intent(this,Weight.class);
                startActivity(i);
                break;

            case R.id.a1:
                i = new Intent(this,Area.class);
                startActivity(i);
                break;

            case R.id.v1:
                i = new Intent(this,Volume.class);
                startActivity(i);
                break;

            case R.id.c1:
                i = new Intent(this,Current.class);
                startActivity(i);
                break;
        }
    }
}