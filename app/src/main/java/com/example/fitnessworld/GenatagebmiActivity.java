package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GenatagebmiActivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi,mgenarate_your_owne_Ditetplan;

    //declare variables
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genatagebmi);

        //change action bar features
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#FFAC1C"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();//collect data from previous activity

        //Assign xml id to java id.
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);
        mgenarate_your_owne_Ditetplan=findViewById(R.id.genarate_your_owne_Ditetplan);

        //take the data from user for height and weight.
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        //convert height and weight into float
        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        //convert height into meter
        intheight=intheight/100;

        //calculate bmi
        intbmi=intweight/(intheight*intheight);

        //convert bmi inti string
        mbmi=Float.toString(intbmi);

        //check bmi in different gender,height,weight and age.
        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cross);
        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");
            //mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<25 && intbmi>18.4)
        {
            mbmicategory.setText("Normal");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.correct);
        }
        else if(intbmi<29.4 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
            {
                mbmicategory.setText("Obese Class I");
                mbackground.setBackgroundColor(Color.RED);
                mimageview.setImageResource(R.drawable.warning);
            }

        //show gender of user
        mgender.setText(intent.getStringExtra("gender"));//gender is fetching from previous activity
        mbmidisplay.setText(mbmi);

//        getSupportActionBar().hide();
        //initialising buttons
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        //create a listener for recalculatebmi button.
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GenatagebmiActivity.this,BMICalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //initialising buttons
        mgenarate_your_owne_Ditetplan=findViewById(R.id.genarate_your_owne_Ditetplan);

        //create a listener for generate_your_own_Diet_plan button.
        mgenarate_your_owne_Ditetplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GenatagebmiActivity.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}