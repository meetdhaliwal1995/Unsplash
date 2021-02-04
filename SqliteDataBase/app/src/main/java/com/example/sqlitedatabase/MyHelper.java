package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public static final String name = "mydb";
    private static final int version = 1;

    public MyHelper(@Nullable Context context) {
        super(context, name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = "CREATE TABLE PRODUCTES(_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DESCRIPTION TEXT,PRICE REAL)";
        db.execSQL(sql);
        insertData("manjeet ","dhaliwal jatt",420,db);
        insertData("manpreet","dhillon jatt",421,db);
        insertData("alpish ","ghuman jatt",422,db);


    }

    private void insertData(String name, String description, double price, SQLiteDatabase database){

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("des",description);
        contentValues.put("price",price);
        database.insert("PRODUCTES", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
