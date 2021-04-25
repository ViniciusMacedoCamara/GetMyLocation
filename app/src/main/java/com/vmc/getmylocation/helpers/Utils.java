package com.vmc.getmylocation.helpers;

import android.content.Context;
import android.util.Log;

public class Utils {
    final String tag = "UTILS";
//    Context context;

    public Utils() {

    }

    public String checkAllFields (String lat, String lon, String local) {

        Log.d(tag, "--------------");
        Log.d(tag, String.valueOf(lat));
        if (!lat.isEmpty() && !lon.isEmpty()) {
            Log.d(tag, "Local Vazio lat e lon preenchidos");
            if (!local.isEmpty()) return lat + "," + lon + "(" + local + ")";
            else return lat + "," + lon;
        } else
            Log.d(tag, "vazio");
            return "false";
    }
}
