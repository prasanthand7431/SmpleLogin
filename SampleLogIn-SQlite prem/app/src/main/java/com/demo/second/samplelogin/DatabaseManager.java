package com.demo.second.samplelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {

    SQLiteDatabase mSQLiteDatabase;

    private final static String TAG="DatabaseManager";
    public DatabaseManager(Context context) {
        super(context, "users.db", null, 1);
        mSQLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table users_data(Name text,Number text,Password text,Email text,Location text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveIt(String sName, String sMobileNumber, String sPassword, String sEmailId, String sLocation) {

        ContentValues cv=new ContentValues();
        cv.put("Name",sName);
        cv.put("Number",sMobileNumber);
        cv.put("Password",sPassword);
        cv.put("Email",sEmailId);
        cv.put("Location",sLocation);

        long h=mSQLiteDatabase.insert("users_data",null,cv);
        return h;
    }


    public int checkUser(String sUserName, String sPassword) {

        Log.d(TAG,"checkUser is called ");

        Cursor cursor;
        cursor=mSQLiteDatabase.query("users_data",null,"Number=?",new String[]{sUserName},null,null,null);
        cursor.moveToFirst();
        String temp=cursor.getString(cursor.getColumnIndex("Password"));
        Log.d(TAG,"password is "+temp);

        if(sPassword.equals(temp)){
            return 1;
        }else{

            return 0;
        }

    }

    public  Cursor fetchData(String userid){

        Cursor cursor;
        cursor=mSQLiteDatabase.query("users_data",null,"Number=?",new String[]{userid},null,null,null);
        cursor.moveToFirst();

        return cursor;
    }
}
