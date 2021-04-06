package com.example.szalufa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText szelvenySzelesseg;
    EditText szerkezetSzelesseg;
    EditText darab;
    TextView szelvenyKoz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGui();
    }

    public void initGui(){
        szelvenySzelesseg = findViewById(R.id.szelvenySzelessegEdit);
        szerkezetSzelesseg = findViewById(R.id.szerkezetSzelessegEdit);
        darab = findViewById(R.id.darabEdit);
        szelvenyKoz = findViewById(R.id.szelvenyKozTxt);
    }

    public void click(View V){
        szelvenyKoz.setText(kozSzamol(szelvenySzelesseg.getText().toString(),szerkezetSzelesseg.getText().toString(),darab.getText().toString()));
    }

    public String kozSzamol(String szelvenySzelesseg, String szerkezetSzelesseg, String darab){
        Double dSzelvenySzelesseg, dSzerkezetSzelesseg, dDarab, dSzelvenyKoz;
        dSzelvenySzelesseg = Double.parseDouble(szelvenySzelesseg);
        dSzerkezetSzelesseg = Double.parseDouble(szerkezetSzelesseg);
        dDarab = Double.parseDouble(darab);
        dSzelvenyKoz = ((dSzerkezetSzelesseg - (dSzelvenySzelesseg * dDarab)) / (dDarab - 1));
        dSzelvenyKoz = kerekit(dSzelvenyKoz,3);
        return dSzelvenyKoz.toString();
    }

    public Double kerekit(Double szam, Integer jegy){
        szam = szam * Math.pow(10,jegy);
        szam = Double.valueOf(Math.round(szam));
        szam = szam / Math.pow(10,jegy);
        return szam;
    }
}