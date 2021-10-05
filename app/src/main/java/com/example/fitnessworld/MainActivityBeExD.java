package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivityBeExD extends AppCompatActivity {

    TextView timer4;
    public ImageView img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_be_ex_d);

        img6 = (ImageView) findViewById(R.id.imgViewBeExD);

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivityBeExD.this,MainActivity6.class);
                startActivity(intent);
            }
        });

        //assign variable
        timer4 = findViewById(R.id.txtTimer4);

        //initialize timer duration
        long duration = TimeUnit.MINUTES.toMillis(1);

        //initialize countdown timer
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                //when tick
                //convert millisecond to minute and second
                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(l)
                        ,TimeUnit.MILLISECONDS.toSeconds(l) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                //set converted string on text view
                timer4.setText(sDuration);
            }

            @Override
            public void onFinish() {
                //when finish
                //hide text view
                timer4.setVisibility(View.GONE);

                //display toast
                Toast.makeText(getApplicationContext()
                        ,"Countdown timer has ended",Toast.LENGTH_LONG).show();

            }
        }.start();
    }
}