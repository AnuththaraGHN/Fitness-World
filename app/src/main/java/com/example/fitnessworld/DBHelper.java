package com.example.fitnessworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.concurrent.Callable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "fitnessworld.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table user(gender TEXT primary key, weight TEXT, wakeuptime TEXT , bedtime TEXT)");
        DB.execSQL("create table login (username TEXT primary key, password TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists user");
        DB.execSQL("Drop table if exists login ");

    }

    public Boolean InsertLoginData(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result= db.insert("login",null, values);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username=?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username=? and password=?", new String[]{username,password});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

//Insert method
    public boolean insertuserdata(String gender, String weight, String wakeuptime, String bedtime){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("gender", gender);
        contentValues.put("weight", weight);
        contentValues.put("wakeuptime", wakeuptime);
        contentValues.put("bedtime", bedtime);
        long result=DB.insert("user",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }

//Update method
    public boolean updateuserdata(String gender, String weight, String wakeuptime, String bedtime) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("weight", weight);
        contentValues.put("wakeuptime", wakeuptime);
        contentValues.put("bedtime", bedtime);
        Cursor cursor = DB.rawQuery("select * from user where gender=?", new String[]{gender});
        if (cursor.getCount() > 0) {


        long result = DB.update("user", contentValues, "gender=?", new String[]{gender});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
        } else {
            return false;
        }
    }

//Delete method
    public boolean deleteuserdata(String gender) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where gender=?", new String[]{gender});
        if (cursor.getCount() > 0) {


            long result = DB.delete("user", "gender=?", new String[]{gender});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

//view details
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user", null);
        return cursor;
    }


}
