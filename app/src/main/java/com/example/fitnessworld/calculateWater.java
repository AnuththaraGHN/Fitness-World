package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculateWater extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claculate_water);

        ed1 = findViewById(R.id.ml1);
        ed2 = findViewById(R.id.ml2);
        ed3 = findViewById(R.id.ml3);
        ed4 = findViewById(R.id.ml4);
        ed5 = findViewById(R.id.ml5);
        ed6 = findViewById(R.id.ml6);
        ed7 = findViewById(R.id.tot1);

        btn1 = findViewById(R.id.btninsert1);
        btn2 = findViewById(R.id.btninsert2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watercal();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

    }

    public void watercal(){
        int w1,w2,w3,w4,w5,w6,tot;
        w1=0;
        w2=0;
        w3=0;
        w4=0;
        w5=0;
        w6=0;

            if((ed1.getText().toString().trim().length()==0)||(ed2.getText().toString().trim().length()==0)||(ed3.getText().toString().trim().length()==0)||(ed4.getText().toString().trim().length()==0)||(ed5.getText().toString().trim().length()==0)||(ed6.getText().toString().trim().length()==0)){
                Toast.makeText(getApplicationContext(),"Fill all fields...",Toast.LENGTH_SHORT).show();
            }else{
                w1 = Integer.parseInt(ed1.getText().toString());
                w2 = Integer.parseInt(ed2.getText().toString());
                w3 = Integer.parseInt(ed3.getText().toString());
                w4 = Integer.parseInt(ed4.getText().toString());
                w5 = Integer.parseInt(ed5.getText().toString());
                w6 = Integer.parseInt(ed6.getText().toString());
                tot = w1+ w2+ w3+ w4+ w5+ w6;

                ed7.setText(String.valueOf(tot));
            }



    }

    public void clear(){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed7.setText("");
        ed1.requestFocus();

    }
}