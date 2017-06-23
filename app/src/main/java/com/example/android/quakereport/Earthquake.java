package com.example.android.quakereport;

/**
 * Data object to hold the data of each single earthquake
 * Created by Jens Greiner on 18.06.17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(String magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude='" + mMagnitude + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mDate='" + mTimeInMilliseconds + '\'' +
                '}';
    }
}
