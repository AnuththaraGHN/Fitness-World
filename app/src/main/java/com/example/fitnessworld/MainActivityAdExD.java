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

public class MainActivityAdExD extends AppCompatActivity {

    TextView timer10;
    public ImageView img12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ad_ex_d);

        img12 = (ImageView) findViewById(R.id.imgViewAdExD);

        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivityAdExD.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        //assign variable
        timer10 = findViewById(R.id.txtTimer10);

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
                timer10.setText(sDuration);
            }

            @Override
            public void onFinish() {
                //when finish
                //hide text view
                timer10.setVisibility(View.GONE);

                //display toast
                Toast.makeText(getApplicationContext()
                        ,"Countdown timer has ended",Toast.LENGTH_LONG).show();

            }
        }.start();
    }
}