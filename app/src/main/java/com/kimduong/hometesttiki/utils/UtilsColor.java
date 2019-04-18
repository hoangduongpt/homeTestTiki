package com.kimduong.hometesttiki.utils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

public class UtilsColor {
    public static GradientDrawable getRamdomColor(){
        Random r = new Random();
        int red= r.nextInt(256);
        int green= r.nextInt(256);
        int blue= r.nextInt(256);

        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(Color.rgb(red,green,blue));
        return draw;
    }
}
