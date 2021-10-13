package com.example.alex.emomem;

import android.content.SharedPreferences;

public interface MyEventListener {

    void setUserCount(int newCount);

    int getCurrentUserNumber();

    void setCurrentUserNumber(int newCurrentUserNumber);

    void cycleCurrentUserNumber();

    SharedPreferences getSharedPreferences();

    void enableKeepScreenOn();

    void disableKeepScreenOn();

}