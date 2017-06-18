package com.example.android.quakereport;

/**
 * Data object to hold the data of each single earthquake
 * Created by Jens Greiner on 18.06.17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude='" + mMagnitude + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mDate='" + mDate + '\'' +
                '}';
    }
}
