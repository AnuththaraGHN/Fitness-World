package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity2 extends AppCompatActivity {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button6;
    public ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button3);
        button3 = (Button) findViewById(R.id.button2);
        button6 = (Button) findViewById(R.id.button5);
        img = (ImageView) findViewById(R.id.imageView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity6.class);
                startActivity(intent);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(intent);
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity5.class);
                startActivity(intent);
            }
        });



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}