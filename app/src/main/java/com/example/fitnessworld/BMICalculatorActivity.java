package com.example.fitnessworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BMICalculatorActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    //creating variables
    TextView mcurrentheight;
    TextView mcurrentage,mcurrentweight;
    ImageView mdecrementweight,mincrementweight,mdecrementage,mincrementage;
    SeekBar mseekbarforheight;
    RelativeLayout mmale,mfemale;

    //creating default variables
    int intweight = 55;
    int intage = 22;
    int currentprogress;
    String mintprogress="170";
    String typeofuser;
    String weight2="55";
    String age2="22";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        //Assign xml id to java id. Initialising buttons, data and seekbar
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incrementweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);


        //create a listener for male button.
        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser="Male";
            }
        });

        //create a listener for female button.
        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        //create a listener for seekbar.
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //create a listener for age increment button.
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        //create a listener for age decrement button.
        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        //create a listener for weight increment button.
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        //create a listener for weight decrement button.
        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        //create a listener for calculate BMI button.
        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check conditions and display toast message
                if(typeofuser.isEmpty()){
                    Toast.makeText(BMICalculatorActivity.this,"Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(BMICalculatorActivity.this,"Select Your Height First",Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 || intage<0){
                    Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 || intweight<0){
                    Toast.makeText(getApplicationContext(),"Weight is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(BMICalculatorActivity.this, GenatagebmiActivity.class);

                    //in here pass some data, because this data need to calculate bmi
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }

            }
        });
    }
}