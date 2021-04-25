package com.vmc.getmylocation.helpers;

import android.content.Context;
import android.util.Log;

public class Utils {
    final String tag = "UTILS";
//    Context context;

    public Utils() {

    }

    public String checkAllFields (String lat, String lng, String local) {



        Log.d(tag, "--------------");
        Log.d(tag, String.valueOf(lat));
        if (!lat.isEmpty() && !lng.isEmpty()) {
            Log.d(tag, "Local Vazio lat e lon preenchidos");

            boolean fieldsRegex = latLngRegex(lat, lng);

            if (fieldsRegex){
                if (!local.isEmpty()) return lat + "," + lng + "(" + local + ")";
                else return lat + "," + lng;
            } else {
                return "Campos invalidos";
            }
        } else
            Log.d(tag, "vazio");
            return "false";
    }

    private boolean latLngRegex(String lat, String lng) {
        if (lat.matches("^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$") && lng.matches("^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$")){
            Log.d(tag, "lat lng valida");
            Log.d(tag, lat + lng);
            return true;
        } else return false;
    }
}
