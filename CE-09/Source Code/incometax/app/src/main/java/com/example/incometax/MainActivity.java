package com.example.incometax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText am,ag;
    TextInputEditText hrat,pt,d80,hi,m,el,sd,npst,d,od;
    Button b1,b2;
    RadioButton oldr, newr;
    Float Total,Tax,min,abc;
    int newre1;
    TextView income,dedu,tx,to;
    TextView in,txt1,txt2;
    LinearLayout LL,llb;
    RelativeLayout RL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = findViewById(R.id.amount);
        ag = findViewById(R.id.ageet);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.clear);
        in = findViewById(R.id.rincome);
        hrat = findViewById(R.id.hra);
        pt = findViewById(R.id.professionaltax);
        d80 =findViewById(R.id.c);
        hi=findViewById(R.id.housing_interest);
        m=findViewById(R.id.medical);
        el=findViewById(R.id.education);
        sd=findViewById(R.id.standard_deductions);
        npst=findViewById(R.id.nps);
        d=findViewById(R.id.donations);
        od=findViewById(R.id.other);
        income = findViewById(R.id.txtincome);
        dedu = findViewById(R.id.txt1);
        tx = findViewById(R.id.deduction);
        to = findViewById(R.id.txttotal);
        oldr = findViewById(R.id.oldregim);
        newr = findViewById(R.id.newregim);
        LL = findViewById(R.id.ll);
        RL = findViewById(R.id.relative);
        llb =findViewById(R.id.libtn);
        txt1=findViewById(R.id.txt);
        txt2=findViewById(R.id.txt1);
        oldr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.setVisibility(View.VISIBLE);
                newre1 = 1;

            }
        });
        newr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL.setVisibility(View.GONE);
                txt1.setVisibility(View.GONE);
                txt2.setVisibility(View.GONE);
                newre1 = 2;
            }
        });
    }


    public void onButton1Click(View view) {
        if(setError()){
            if (newre1 == 1) {
                float amo = Float.parseFloat(am.getText().toString());
                float age1 = Float.parseFloat(ag.getText().toString());


                if (hrat.getText().toString().equals("")) {
                    hrat.setText("0");
                }

                float Hraf = Float.parseFloat(hrat.getText().toString());
                Float h12;
                h12 = amo / 2;
                if (Hraf >= h12) {
                    Hraf = h12;
                    Toast.makeText(this, "" + Hraf, Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "" + Hraf, Toast.LENGTH_SHORT).show();
                }
                if (pt.getText().toString().equals("")) {
                    pt.setText("0");
                }

                float ptf = Float.parseFloat(pt.getText().toString());
                if (ptf >= 2500) {
                    ptf = 2500;
                    Toast.makeText(this, "" + ptf, Toast.LENGTH_SHORT).show();
                }
                if (d80.getText().toString().equals("")) {
                    d80.setText("0");
                }

                float d80f = Float.parseFloat(d80.getText().toString());
                if (d80f >= 150000) {
                    d80f = 150000;
                    Toast.makeText(this, "" + d80f, Toast.LENGTH_SHORT).show();
                }

                if (hi.getText().toString().equals("")) {
                    hi.setText("0");
                }

                float hif = Float.parseFloat(hi.getText().toString());

                if (m.getText().toString().equals("")) {
                    m.setText("0");
                }
                float mf = Float.parseFloat(m.getText().toString());
                if (el.getText().toString().equals("")) {
                    el.setText("0");
                }

                float elf = Float.parseFloat(el.getText().toString());
                if (sd.getText().toString().equals("")) {
                    sd.setText("0");
                }
                float sdf = Float.parseFloat(sd.getText().toString());
                if (npst.getText().toString().equals("")) {
                    npst.setText("0");
                }
                float npsf = Float.parseFloat(npst.getText().toString());
                if (d.getText().toString().equals("")) {
                    d.setText("0");
                }
                float df = Float.parseFloat(d.getText().toString());
                if (od.getText().toString().equals("")) {
                    od.setText("0");
                }
                float odf = Float.parseFloat(od.getText().toString());

                abc = Hraf + ptf + d80f + hif + mf + elf + sdf + npsf + df + odf;
                if (abc >= amo) {
                    Toast.makeText(this, "Please Enter Currect Detail", Toast.LENGTH_SHORT).show();
                } else {
                    if (age1 < 60) {
                        min = amo - abc;
                        if (min <= 250000) {

                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min < 1000000) {
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 1000001 && min < 1250000) {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                    } else if (age1 >= 61 && age1 <= 80) {
                        min = amo - abc;
                        if (min <= 250000) {

                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min < 1000000) {
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 1000001 && min < 1250000) {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        min = amo - abc;
                        if (min <= 250000) {

                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min < 1000000) {
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 1000001 && min < 1250000) {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            } else {
                float amo = Float.parseFloat(am.getText().toString());
                float age1 = Float.parseFloat(ag.getText().toString());


                if (hrat.getText().toString().equals("")) {
                    hrat.setText("0");
                }

                float Hraf = Float.parseFloat(hrat.getText().toString());
                Float h12;
                h12 = amo / 2;
                if (Hraf >= h12) {
                    Hraf = h12;
                    Toast.makeText(this, "" + Hraf, Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "" + Hraf, Toast.LENGTH_SHORT).show();
                }
                if (pt.getText().toString().equals("")) {
                    pt.setText("0");
                }

                float ptf = Float.parseFloat(pt.getText().toString());
                if (ptf >= 2500) {
                    ptf = 2500;
                    Toast.makeText(this, "" + ptf, Toast.LENGTH_SHORT).show();
                }
                if (d80.getText().toString().equals("")) {
                    d80.setText("0");
                }

                float d80f = Float.parseFloat(d80.getText().toString());
                if (d80f >= 150000) {
                    d80f = 150000;
                    Toast.makeText(this, "" + d80f, Toast.LENGTH_SHORT).show();
                }

                if (hi.getText().toString().equals("")) {
                    hi.setText("0");
                }

                float hif = Float.parseFloat(hi.getText().toString());

                if (m.getText().toString().equals("")) {
                    m.setText("0");
                }
                float mf = Float.parseFloat(m.getText().toString());
                if (el.getText().toString().equals("")) {
                    el.setText("0");
                }

                float elf = Float.parseFloat(el.getText().toString());
                if (sd.getText().toString().equals("")) {
                    sd.setText("0");
                }
                float sdf = Float.parseFloat(sd.getText().toString());
                if (npst.getText().toString().equals("")) {
                    npst.setText("0");
                }
                float npsf = Float.parseFloat(npst.getText().toString());
                if (d.getText().toString().equals("")) {
                    d.setText("0");
                }
                float df = Float.parseFloat(d.getText().toString());
                if (od.getText().toString().equals("")) {
                    od.setText("0");
                }
                float odf = Float.parseFloat(od.getText().toString());

                abc = Hraf + ptf + d80f + hif + mf + elf + sdf + npsf + df + odf;
                if (abc >= amo) {
                    Toast.makeText(this, "Please Enter Currect Detail", Toast.LENGTH_SHORT).show();
                } else {
                    if (age1 < 60) {
                        min = amo - abc;
                        if (min <= 250000) {
                            income.setText("" + amo);
                            dedu.setText("" + abc);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 10) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min<1000000) {
                            Tax = (min * 15) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1000001 && min<1250000){
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1250001 && min<1500000){
                            Tax = (min * 25) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);
                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if (age1 >= 61 && age1 <= 80) {
                        min = amo - abc;
                        if (min <= 250000) {
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 10) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min<1000000) {
                            Tax = (min * 15) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1000001 && min<1250000){
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1250001 && min<1500000){
                            Tax = (min * 25) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        min = amo - abc;
                        if (min <= 250000) {
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is Nil new ", Toast.LENGTH_SHORT).show();
                        } else if (min >= 250001 && min < 500000) {

                            Tax = (min * 5) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 500001 && min < 750000) {

                            Tax = (min * 10) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        } else if (min >= 750001 && min<1000000) {
                            Tax = (min * 15) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1000001 && min<1250000){
                            Tax = (min * 20) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else if (min >= 1250001 && min<1500000){
                            Tax = (min * 25) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Tax = (min * 30) / 100;
                            Total = amo + Tax;
                            income.setText("" + amo);

                            tx.setText("" + Total);
                            to.setText("" + Tax);
                            Toast.makeText(MainActivity.this, "Your tax is" + Tax, Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
            RL.setVisibility(View.VISIBLE);

        }

        }
    public void onButtonClick(View view){
        am.setText("");
        ag.setText("");
        hrat.setText("");
        pt.setText("");
        d80.setText("");
        hi.setText("");
        m.setText("");
        el.setText("");
        sd.setText("");
        npst.setText("");
        d.setText("");
        od.setText("");
        RL.setVisibility(View.GONE);
    }
    private boolean setError()
    {
        if  (am.getText().toString().isEmpty()) {
            am.setError("please enter amount ");
            return false;
        }
        if (ag.getText().toString().isEmpty()) {
            ag.setError("please enter Age ");
            return false;
        }
        return true;
    }
}