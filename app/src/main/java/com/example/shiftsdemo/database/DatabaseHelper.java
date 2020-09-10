package com.example.shiftsdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.shiftsdemo.Constants.AGE;
import static com.example.shiftsdemo.Constants.EMAIL;
import static com.example.shiftsdemo.Constants.NAME;
import static com.example.shiftsdemo.Constants.PASSWORD;
import static com.example.shiftsdemo.Constants.USERID;
import static com.example.shiftsdemo.Constants.USERS;

class DatabaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "SHIFTS_APP.DB";
    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + USERS + "(" + USERID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT NOT NULL, " + AGE + " TEXT NOT NULL, " +
            EMAIL + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "onCreate: creating tables");
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_USERS_TABLE);
        onCreate(db);
    }
}