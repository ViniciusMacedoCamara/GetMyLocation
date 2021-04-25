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
        Log.d(tag, String.valueOf(lat +" - "+ lng));
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

    public boolean latLngRegex(String lat, String lng) {
        Log.d(tag, "|||||||||");
        Log.d(tag, String.valueOf(lat.length() +" | "+ lat));
        if(lat.length() > 10){
            lat = trimString(lat);
            Log.d(tag, lat.length() +" || "+ lat);
        }

        if(lng.length() > 10){
            lng = trimString(lng);
            Log.d(tag, lng.length() +" ||| "+ lng);
        }

        String str = "Java83";

        str = str.substring(0, str.length() - 1);
        Log.d(tag, str);

        if (lat.matches("^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$") && lng.matches("^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$")){
            Log.d(tag, "lat lng valida");
            Log.d(tag, lat + lng);
            return true;
        } else return false;
    }

    public String trimString (String s) {
        Log.d(tag, "sssssssssssssssssss");
        Log.d(tag, s);
        int n = s.length() - 10;
        Log.d(tag, String.valueOf(n));
        s = s.substring(0, s.length() - n);
        Log.d(tag, s);
        Log.d(tag, "nnnnnnnnnnnnnnnnnn");
        return s;
    }

}
