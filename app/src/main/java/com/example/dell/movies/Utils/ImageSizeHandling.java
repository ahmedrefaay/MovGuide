package com.example.dell.movies.Utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.dell.movies.App.Const;

public class ImageSizeHandling extends ColoumnsNumber {

    static int imagewidth;

    public static int getImageSize(Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        imagewidth = displayMetrics.widthPixels / getColoumns(context);

        return imagewidth;
    }

    public static int getBackDropSize(Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        imagewidth = displayMetrics.widthPixels;

        return imagewidth;
    }
}
