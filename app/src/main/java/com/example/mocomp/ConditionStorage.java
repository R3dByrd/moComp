package com.example.mocomp;

import android.content.Context;
import android.content.SharedPreferences;

public class ConditionStorage {
    private static final String PREFS = "conditions";

    public static void increment(Context context, String status) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        int current = prefs.getInt(status, 0);
        prefs.edit().putInt(status, current + 1).apply();
    }

    public static int get(Context context, String status) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return prefs.getInt(status, 0);
    }
}
