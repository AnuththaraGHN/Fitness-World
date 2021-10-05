package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    public Button button4;
    public ImageView img2;
    public TextView txt1;
    public TextView txt2;
    public TextView txt3;
    public TextView txt4;
    public TextView txt5;
    public TextView txt6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        button4 = (Button) findViewById(R.id.btnBackB);
        img2 = (ImageView) findViewById(R.id.imgView7);
        txt1 = (TextView) findViewById(R.id.txtBExA);
        txt2 = (TextView) findViewById(R.id.txtBExB);
        txt3 = (TextView) findViewById(R.id.txtBExC);
        txt4 = (TextView) findViewById(R.id.txtBExD);
        txt5 = (TextView) findViewById(R.id.txtBExE);
        txt6 = (TextView) findViewById(R.id.txtBExF);


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExA.class);
                startActivity(intent);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExB.class);
                startActivity(intent);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExC.class);
                startActivity(intent);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExD.class);
                startActivity(intent);
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExE.class);
                startActivity(intent);
            }
        });

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity6.this,MainActivityBeExF.class);
                startActivity(intent);
            }
        });
    }
}