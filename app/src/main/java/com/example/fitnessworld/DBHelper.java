package com.example.fitnessworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "fitnessworld.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table womenworkouts(name Text primary key, category Text, goal Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists womenworkouts");

    }

    public Boolean insertuserdata(String name, String category, String goal)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("goal", goal);
        long result=DB.insert("womenworkouts", null, contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata(String name, String category, String goal)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", category);
        contentValues.put("goal", goal);
        Cursor cursor = DB.rawQuery("select * from womenworkouts where name = ?", new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = DB.update("womenworkouts", contentValues, "name=?", new String[]  {name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        }else
        {
            return false;
        } }

        public Boolean deletedata(String name)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("select * from womenworkouts where name = ?", new String[]{name});
            if(cursor.getCount()>0)
            {
                long result = DB.delete("womenworkouts", "name=?", new String[]{name});
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }

            }else
            {
                return false;
            }

        }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from womenworkouts", null);
        return cursor;

    }

}
