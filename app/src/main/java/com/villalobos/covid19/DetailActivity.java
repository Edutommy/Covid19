package com.villalobos.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    String country, code, cases, tc, nd, td, nr, tr;
    TextView txtCOUNTRY, txtCODE, txtCASES, txtTC, txtND, txtTD, txtNR, txtTR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //initialize values from RecycleView
        country = getIntent().getStringExtra("COUNTRY");
        code = getIntent().getStringExtra("CODE");
        cases = getIntent().getStringExtra("CASES");
        tc = getIntent().getStringExtra("TotalConfirmed");
        nd = getIntent().getStringExtra("NEWDEAD");
        td = getIntent().getStringExtra("TotalDead");
        nr = getIntent().getStringExtra("NewRecovered");
        tr = getIntent().getStringExtra("TotalRecovered");

        //cargar los controles del detalle
        txtCOUNTRY = findViewById(R.id.detail_country);
        txtCODE = findViewById(R.id.detail_code);
        txtCASES = findViewById(R.id.detail_cases);
        txtTC = findViewById(R.id.detail_totalConfirmed);
        txtND = findViewById(R.id.detail_newDead);
        txtTD = findViewById(R.id.detail_totalDead);
        txtNR = findViewById(R.id.detail_newRecovered);
        txtTR = findViewById(R.id.detail_totalRecovered);

        txtCOUNTRY.setText(country);
        txtCODE.setText(code);
        txtCASES.setText(cases);
        txtTC.setText(tc);
        txtND.setText(nd);
        txtTD.setText(td);
        txtNR.setText(nr);
        txtTR.setText(tr);


    }
}