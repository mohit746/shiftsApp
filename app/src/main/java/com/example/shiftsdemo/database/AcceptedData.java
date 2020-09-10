package com.example.shiftsdemo.database;

import com.example.shiftsdemo.shifts.MyListData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AcceptedData
{
    SimpleDateFormat format;
    Date currentTime;
    public ArrayList<MyListData> acceptedList = new ArrayList<>();
    private static AcceptedData mAcceptedData = null;

    private AcceptedData() {
        currentTime = Calendar.getInstance().getTime();
        format = new SimpleDateFormat();
        format.applyPattern("E MMM dd, yyyy");
        acceptedList.add(new MyListData(format.format(currentTime), "Narayana hospital", "3:00PM - 11:00PM - 10/10/2020", "Bangalore", "Surgery Department"));
        acceptedList.add(new MyListData(format.format(currentTime), "St. John Hospital", "3:00PM - 11:00PM - 10/10/2020", "Bangalore", "General Department"));
    }

    public static AcceptedData getInstance() {
        if (mAcceptedData == null) {
            mAcceptedData = new AcceptedData();
        }
        return mAcceptedData;
    }

}
