package com.example.shiftsdemo.database;

import com.example.shiftsdemo.shifts.MyListData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AppliedData
{
    SimpleDateFormat format;
    Date currentTime;
    public ArrayList<MyListData> appliedList = new ArrayList<>();
    private static AppliedData mAppliedData = null;

    private AppliedData() {
        currentTime = Calendar.getInstance().getTime();
        format = new SimpleDateFormat();
        format.applyPattern("E MMM dd, yyyy");
        appliedList.add(new MyListData(format.format(currentTime), "Hospital MGR", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));
        appliedList.add(new MyListData(format.format(currentTime), "General Hospital 0", "3:00PM - 11:00PM - 10/10/2020", "Chicago", "Surgery Department"));

    }

    public static AppliedData getInstance() {
        if (mAppliedData == null) {
            mAppliedData = new AppliedData();
        }
        return mAppliedData;
    }

}
