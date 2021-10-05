package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    public Button button5;
    public ImageView img1;
    public TextView txt8;
    public TextView txt9;
    public TextView txt10;
    public TextView txt11;
    public TextView txt12;
    public TextView txt13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button5 = (Button) findViewById(R.id.btnBackA);
        img1 = (ImageView) findViewById(R.id.imgView8);
        txt8 = (TextView) findViewById(R.id.txtAExB);
        txt9 = (TextView) findViewById(R.id.txtAExC);
        txt10 = (TextView) findViewById(R.id.txtAExD);
        txt11 = (TextView) findViewById(R.id.txtAExE);
        txt12 = (TextView) findViewById(R.id.txtAExF);
        txt13 = (TextView) findViewById(R.id.txtAExG);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
            }
        });



        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExB.class);
                startActivity(intent);
            }
        });

        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExC.class);
                startActivity(intent);
            }
        });

        txt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExD.class);
                startActivity(intent);
            }
        });

        txt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExE.class);
                startActivity(intent);
            }
        });

        txt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExF.class);
                startActivity(intent);
            }
        });

        txt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this,MainActivityAdExG.class);
                startActivity(intent);
            }
        });


    }
}