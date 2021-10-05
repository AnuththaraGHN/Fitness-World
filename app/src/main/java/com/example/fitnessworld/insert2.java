package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class insert2 extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    int progressValue = 0;
    Button artir,azalt;
    int gCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert2);

        textView = findViewById(R.id.textView2);
        progressBar= findViewById(R.id.progressBar3);
        artir = findViewById(R.id.add);
        azalt = findViewById(R.id.clear);
        float x=100/8;

        artir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressValue<x*8){
//                    Toast.makeText(getApplicationContext(),progressValue, Toast.LENGTH_LONG).show();
                    if(progressValue<84) {
                        gCounter++;
                        progressValue += x;
                        progressBar.setProgress(progressValue);
                        textView.setText(String.valueOf(gCounter));
                    }else{
                        gCounter=8;
                        progressValue=100;
                        progressBar.setProgress(progressValue);
                        textView.setText("8");
                    }
                }
            }
        });

        azalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progressValue>0){
//                    String s=Integer.toString(progressValue);
//                    Toast.makeText(getApplicationContext(),progressValue, Toast.LENGTH_LONG).show();
                    if(progressValue>86){
//                        Toast.makeText(getApplicationContext(),gCounter, Toast.LENGTH_LONG).show();
                        gCounter=7;
                        progressValue=84;
                    }else {
                        gCounter--;
                        progressValue -= x;
                    }
                    progressBar.setProgress(progressValue);
                    textView.setText(String.valueOf(gCounter));
                }
            }
        });
    }
}