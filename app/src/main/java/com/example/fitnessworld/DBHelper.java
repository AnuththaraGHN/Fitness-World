package com.example.fitnessworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "text3.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key, category TEXT, your_diet_plan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String name,String category, String your_diet_plan) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        ContentValues.put("category", category);
        ContentValues.put("your_diet_plan", your_diet_plan);
        long result = DB.insert ("userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String name,String category, String your_diet_plan) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues.put("category", category);
        ContentValues.put("your_diet_plan", your_diet_plan);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[] {name});
        if(cursor.getCount()>0){
        long result = DB.update ("userdetails", contentValues, "name=?", new String[] {name});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
        }else{
            return false;
        }

    }
    public Boolean deletedata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[] {name});
        if(cursor.getCount()>0){
            long result = DB.delete ("userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
            }else{
            return false;
        }

    }

    public Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }
}
