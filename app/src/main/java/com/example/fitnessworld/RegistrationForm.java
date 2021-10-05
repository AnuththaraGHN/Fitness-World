package com.example.fitnessworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationForm extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(RegistrationForm.this,"All fields required",Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser =  DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.InsertLoginData(user,pass);
                            if(insert==true){
                                Toast.makeText(RegistrationForm.this,"Registered successfully..!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistrationForm.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(RegistrationForm.this,"Register already Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegistrationForm.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}