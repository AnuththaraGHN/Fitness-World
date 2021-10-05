package com.example.fitnessworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    //creating variables
    EditText name,category,your_diet_plan;
    Button insert,update,delete,view;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //initialising data
        name=findViewById(R.id.name);
        category=findViewById(R.id.category);
        your_diet_plan=findViewById(R.id.your_diet_plan);

        //initialising buttons
        insert=findViewById(R.id.btnInsert);
        update=findViewById(R.id.btnUpdate);
        delete=findViewById(R.id.btnDelete);
        view=findViewById(R.id.btnView);
        DB = new DBHelper(this);

        //create a listener for insert button.
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String categoryTXT = category.getText().toString();
                String your_diet_planTXT = your_diet_plan.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata (nameTXT,categoryTXT,your_diet_planTXT);
                //toast messages for insert data
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity3.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
            }
        });

        //create a listener for update button.
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String categoryTXT = category.getText().toString();
                String your_diet_planTXT = your_diet_plan.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata (nameTXT,categoryTXT,your_diet_planTXT);
                //toast messages for update data
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity3.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this,"New Entry not Updated",Toast.LENGTH_SHORT).show();
            }
        });

        //create a listener for delete button.
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();

                Boolean checkdeletedata = DB.deletedata (nameTXT);
                //toast messages for delete data
                if(checkdeletedata==true)
                    Toast.makeText(MainActivity3.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this,"New Entry not Deleted",Toast.LENGTH_SHORT).show();
            }
        });

        //create a listener for retrieve button.
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata ();
                //toast messages for retrieve data
                if(res.getCount()==0){
                    Toast.makeText(MainActivity3.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name:"+res.getString(0)+"\n");
                    buffer.append("Category:"+res.getString(1)+"\n");
                    buffer.append("Your Diet Plan:"+res.getString(2)+"\n\n");

                }

                //alert message for all the values which we have stored
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

    }
}