package com.example.shiftsdemo.login;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.shiftsdemo.User;
import com.example.shiftsdemo.Utils;
import com.example.shiftsdemo.database.DBManager;
import com.example.shiftsdemo.shifts.MyListData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.shiftsdemo.Constants.AGE;
import static com.example.shiftsdemo.Constants.EMAIL;
import static com.example.shiftsdemo.Constants.NAME;
import static com.example.shiftsdemo.Constants.PASSWORD;
import static com.example.shiftsdemo.Constants.USERS;

public class LoginPresenter {

    private final String TAG = "LoginPresenter";
    private View mView;
    private Context mContext;
    DBManager manager;


    LoginPresenter(Context aContext, View aView) {
        this.mView = aView;
        this.mContext = aContext;
        manager = new DBManager(aContext);
    }

    void loginUser(String aUserName, String aPassword) {
        Log.d(TAG, "loginUser: inside method");
        try {
            manager.open();
            Cursor lCursor = manager.fetch(
                    USERS,
                    new String[]{EMAIL, PASSWORD},
                    EMAIL +" =  ? AND "+PASSWORD+" = ?",
                    new String[]{aUserName, aPassword}
            );
            if (lCursor!=null && lCursor.getCount()>0) {
                while (lCursor.moveToNext()){
                    String lEmail = lCursor.getColumnName(lCursor.getColumnIndex(EMAIL));
                    Log.d(TAG, "loginUser: lEmail in cursor " +lEmail);
                }
                lCursor.close();
                mView.loginResponse(true);
            } else {
                mView.loginResponse(false);
            }
            manager.close();
        }catch (Exception e) {
            e.printStackTrace();
            mView.loginResponse(false);
        }
    }

    void insertDataInDB() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("E MMM dd, yyyy");
        MyListData[] myListData = new MyListData[]{
                new MyListData(format.format(currentTime), "General Hospital 1", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 2", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 3", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 4", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 5", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 6", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 7", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 8", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 9", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 10", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 11", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 12", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 13", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 14", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
                new MyListData(format.format(currentTime), "General Hospital 15", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"),
        };

    }

    interface View {
        void loginResponse(boolean aResult);
    }
}
