package com.example.shiftsdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.shiftsdemo.Constants.AGE;
import static com.example.shiftsdemo.Constants.EMAIL;
import static com.example.shiftsdemo.Constants.NAME;
import static com.example.shiftsdemo.Constants.PASSWORD;
import static com.example.shiftsdemo.Constants.USERID;
import static com.example.shiftsdemo.Constants.USERS;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insert(String aTableName, ContentValues contentValues) {
        return database.insert(aTableName, null, contentValues);
    }

    public Cursor fetch(String aTable, String[] columns, String selection, String[] selectionArgs) {
        Cursor cursor = database.query(aTable, columns, selection, selectionArgs, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(String aTableName, String aWhereClause, ContentValues contentValues) {
        int i = database.update(aTableName, contentValues, aWhereClause, null);
        return i;
    }

    public void delete(String aTableName, String aWhereClause) {
        database.delete(aTableName, aWhereClause, null);
    }

}