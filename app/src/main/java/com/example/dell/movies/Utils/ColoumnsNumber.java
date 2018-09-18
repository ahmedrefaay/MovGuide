package com.example.dell.movies.Utils;

import android.content.Context;
import android.content.res.Configuration;

public class ColoumnsNumber {

    static int Coloumns;

    public static int getColoumns(Context context) {
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Coloumns = 4;
        } else {
            Coloumns = 3;
        }
        return Coloumns;
    }
}
