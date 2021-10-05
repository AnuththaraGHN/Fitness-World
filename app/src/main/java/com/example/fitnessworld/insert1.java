package com.example.fitnessworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insert1 extends AppCompatActivity {

    EditText gender, weight, wakeuptime, bedtime;
    Button insert, update, delete, view;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert1);

        gender = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);
        wakeuptime = findViewById(R.id.wakeuptime);
        bedtime = findViewById(R.id.bedtime);

        insert = findViewById(R.id.btninsert);
        update = findViewById(R.id.btnupdate);
        delete = findViewById(R.id.btndelete);
        view = findViewById(R.id.btnview);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genderTXT = gender.getText().toString();
                String weightTXT = weight.getText().toString();
                String wakeuptimeTXT = wakeuptime.getText().toString();
                String bedtimeTXT = bedtime.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(genderTXT, weightTXT, wakeuptimeTXT, bedtimeTXT);
                if (checkinsertdata == true)
                    Toast.makeText(insert1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(insert1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genderTXT = gender.getText().toString();
                String weightTXT = weight.getText().toString();
                String wakeuptimeTXT = wakeuptime.getText().toString();
                String bedtimeTXT = bedtime.getText().toString();

                Boolean checkupdatetdata = DB.updateuserdata(genderTXT, weightTXT, wakeuptimeTXT, bedtimeTXT);
                if (checkupdatetdata == true)
                    Toast.makeText(insert1.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(insert1.this, "Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genderTXT = gender.getText().toString();

                Boolean checkdeletedata = DB.deleteuserdata(genderTXT);
                if (checkdeletedata == true)
                    Toast.makeText(insert1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(insert1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(insert1.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("gender :" + res.getString(0) + "\n");
                    buffer.append("weight :" + res.getString(1) + "\n");
                    buffer.append("wakeuptime :" + res.getString(2) + "\n");
                    buffer.append("bedtime :" + res.getString(3) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(insert1.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}