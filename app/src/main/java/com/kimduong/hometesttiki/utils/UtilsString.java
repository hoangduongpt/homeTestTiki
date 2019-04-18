package com.kimduong.hometesttiki.utils;

import android.util.Log;

public class UtilsString {


    public static String parserTwoLine(String text){
        if(!text.contains(" "))return text; // Check String a word
        int length = text.length();
        int center = length /2;
        char[] chars = text.toCharArray();
        int index = center;
        if(chars[index] == ' '){
            chars[index] = '\n';
            return String.valueOf(chars);
        }
        int i_left;
        int i_right;
        int find = -1 ;
        for(int i = 0; i < center; i+=1 ){
            i_left = center - i;

            if (chars[i_left] == ' ') {
                find = i_left;
                break;
            }

            i_right = center + i;

            if (chars[i_right] == ' '){
                find = i_right;
                break;
            }

        }

        chars[find] = '\n';

        return String.valueOf(chars);
    }

}
