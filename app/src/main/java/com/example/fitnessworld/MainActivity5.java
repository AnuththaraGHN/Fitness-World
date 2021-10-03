package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;


public class MainActivity5 extends AppCompatActivity {

    public Button button7;

    private Button btnCalculate;
    private EditText edtAns, edtInage, edtInheight, edtInweight;
    private TextView txtHeight, txtWeight, txtAge, txtBmrforwomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initialWidgets();

        button7 = (Button) findViewById(R.id.btnback);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity5.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double Weight;
                double Height;
                double Age;
                double bmr3;

                Weight = Double.parseDouble(edtInweight.getText().toString());
                Height = Double.parseDouble(edtInheight.getText().toString());
                Age = Double.parseDouble(edtInage.getText().toString());

                bmr3 = ((10 * Weight) + (6.25 * Height) - (5 * Age) - 161);

                edtAns.setText(bmr3 + "");

            }

        });
    }

    private void initialWidgets() {
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        edtAns = (EditText) findViewById(R.id.edtAns);
        edtInage = (EditText) findViewById(R.id.edtInage);
        edtInheight = (EditText) findViewById(R.id.edtInheight);
        edtInweight = (EditText) findViewById(R.id.edtInweight);
        txtAge = (TextView) findViewById(R.id.txtAge);
        txtBmrforwomen = (TextView) findViewById(R.id.txtBmrforwomen);
        txtWeight = (TextView) findViewById(R.id.txtWeight);
        txtHeight = (TextView) findViewById(R.id.txtHeight);

    }
}