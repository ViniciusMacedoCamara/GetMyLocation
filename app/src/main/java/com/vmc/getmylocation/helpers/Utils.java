package com.vmc.getmylocation.helpers;

public class Utils {

    public Utils() {

    }

    /**
     * Function to check if fiels are filled
     * @param lat
     * @param lng
     * @param local
     * */
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

    /**
     * Function to check latitude and longitude pattern
     * @param lat
     * @param lng
     * */
    public boolean latLngRegex(String lat, String lng) {

        if(lat.length() > 11) lat = trimString(lat);

        if(lng.length() > 11) lng = trimString(lng);

        if (lat.matches("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)") && lng.matches("^[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$")){
            return true;
        } else return false;
    }

    /**
     * Function to trim numbers after 11th digit
     * @param s
     * */
    public String trimString (String s) {
        int n = s.length() - 10;
        s = s.substring(0, s.length() - n);
        return s;
    }

}
