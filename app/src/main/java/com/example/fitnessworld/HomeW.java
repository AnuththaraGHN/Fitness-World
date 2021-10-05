package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class HomeW extends AppCompatActivity {
public Button button1;
public Button button2;
public Button button3;
public Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_w);

        button1 = (Button) findViewById(R.id.Hbtn3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeW.this,insert2.class);
                startActivity(intent);
            }
        });

        button2 = (Button)  findViewById(R.id.Hbtn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeW.this,setReminder.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.Hbtn1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeW.this,calculateWater.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.Hbtn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeW.this,insert1.class);
                startActivity(intent);
            }
        });
    }
}