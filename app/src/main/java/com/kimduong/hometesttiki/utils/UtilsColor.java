package com.kimduong.hometesttiki.utils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

public class UtilsColor {
    public static int getRandomColor(){
        Random r = new Random();
        int red= r.nextInt(256);
        int green= r.nextInt(256);
        int blue= r.nextInt(256);
        return Color.argb(255,red, green,blue);
    }
}
