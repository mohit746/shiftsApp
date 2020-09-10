package com.example.shiftsdemo.database;

import com.example.shiftsdemo.shifts.MyListData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OpenData
{
    SimpleDateFormat format;
    Date currentTime;
    public ArrayList<MyListData> openList = new ArrayList<>();
    private static OpenData mOpenData = null;

    private OpenData() {
        currentTime = Calendar.getInstance().getTime();
        format = new SimpleDateFormat();
        format.applyPattern("E MMM dd, yyyy");
        openList.add(new MyListData(format.format(currentTime), "General Hospital 1", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 2", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 3", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 4", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 5", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 6", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 7", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 8", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 9", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 10", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 11", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 12", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 13", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 14", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        openList.add(new MyListData(format.format(currentTime), "General Hospital 15", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));

    }

    public static OpenData getInstance() {
        if (mOpenData == null) {
            mOpenData = new OpenData();
        }
        return mOpenData;
    }
}
