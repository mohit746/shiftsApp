package com.example.shiftsdemo.shifts;

public class MyListData{
    private String currentTime;
    private String hospitalName;
    private String in_out_time;
    private String location;
    private String department;

    public MyListData(String updateTime, String hospitalName, String inOutTime, String location, String department) {
        this.currentTime = updateTime;
        this.hospitalName = hospitalName;
        this.in_out_time = inOutTime;
        this.location = location;
        this.department = department;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getIn_out_time() {
        return in_out_time;
    }

    public void setIn_out_time(String in_out_time) {
        this.in_out_time = in_out_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}