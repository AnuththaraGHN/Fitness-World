package com.example.fitnessworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialize variables
    EditText name, category, Goal;
    Button insert, update, delete, view;
    DBHelper DB;
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnFirstNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        //assign variables
        name = findViewById(R.id.name);
        category = findViewById(R.id.category);
        Goal = findViewById(R.id.Goal);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText() .toString();
                String categoryTXT = category.getText() .toString();
                String goalTXT = Goal.getText() .toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, categoryTXT, goalTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT) .show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT) .show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText() .toString();
                String categoryTXT = category.getText() .toString();
                String goalTXT = Goal.getText() .toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, categoryTXT, goalTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT) .show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT) .show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText() .toString();

                Boolean checkdeletedata = DB.deletedata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT) .show();
                else
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT) .show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0) {
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;

                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Category :"+res.getString(1)+"\n");
                    buffer.append("Goal :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }



}