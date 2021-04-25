package com.vmc.getmylocation.helpers;

import android.content.Context;
import android.util.Log;

public class Utils {
    final String tag = "UTILS";
//    Context context;

    public Utils() {

    }

    public boolean checkAllFields (String lat, String lon, String local) {

        Log.d(tag, "--------------");
        Log.d(tag, String.valueOf(lat));
        if (!lat.isEmpty() && !lon.isEmpty() && !local.isEmpty()){
            Log.d(tag, "Todos os campos foram preenchidos, fazer verificação");
            //Retornar outra funcao
        } else if (!lat.isEmpty() && !lon.isEmpty()) {
            Log.d(tag, "Local Vazio lat e lon preenchidos");
            return true;
        } else if (!local.isEmpty()) {
            Log.d(tag, "Local preenchido");
            return true;
        } else
            Log.d(tag, "vazio");
            return false;
    }
}
