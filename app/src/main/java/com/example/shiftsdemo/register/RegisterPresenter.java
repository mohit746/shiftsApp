package com.example.shiftsdemo.register;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.shiftsdemo.database.DBManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.example.shiftsdemo.Constants.AGE;
import static com.example.shiftsdemo.Constants.EMAIL;
import static com.example.shiftsdemo.Constants.NAME;
import static com.example.shiftsdemo.Constants.PASSWORD;
import static com.example.shiftsdemo.Constants.USERS;

public class RegisterPresenter {

    private final String TAG = "RegisterPresenter";
    private View mView;
    private Context mContext;
    DBManager manager;

    RegisterPresenter(Context aContext, View aView) {
        this.mView = aView;
        mContext = aContext;
        manager = new DBManager(aContext);
    }

    void registerUser(String name, String age, String email, String password) {
        Log.d(TAG, "registerUser: name " + name + " age " + age + " email " + email +
                " password " + password);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, name);
            contentValues.put(AGE, age);
            contentValues.put(EMAIL, email);
            contentValues.put(PASSWORD, password);
            manager.open();
            manager.insert(USERS, contentValues);
            manager.close();
            mView.registerResponse(true);
        } catch (Exception e) {
            e.printStackTrace();
            mView.registerResponse(false);
        }
    }

    interface View {
        void registerResponse(boolean aResult);
    }
}
