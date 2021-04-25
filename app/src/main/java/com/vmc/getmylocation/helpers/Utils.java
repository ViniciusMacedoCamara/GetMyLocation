package com.vmc.getmylocation.helpers;

public class Utils {

    public Utils() {

    }

    public String checkAllFields (String lat, String lng, String local) {

        if (!lat.isEmpty() && !lng.isEmpty()) {

            boolean fieldsRegex = latLngRegex(lat, lng);

            if (fieldsRegex){
                if (!local.isEmpty()) {
                    return lat + "," + lng + "(" + local + ")";
                } else {
                    return lat + "," + lng;
                }
            } else {
                return "campo_invalido";
            }
        } else return "vazio";
    }

    public boolean latLngRegex(String lat, String lng) {

        if(lat.length() > 10) lat = trimString(lat);

        if(lng.length() > 10) lng = trimString(lng);

        if (lat.matches("^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$") && lng.matches("^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$")){
            return true;
        } else return false;
    }

    public String trimString (String s) {
        int n = s.length() - 10;
        s = s.substring(0, s.length() - n);
        return s;
    }

}
