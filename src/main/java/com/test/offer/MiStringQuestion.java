package com.test.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/9/18.
 */
public class MiStringQuestion {

    public static List<String> out = new ArrayList<>();

    public static void main(String[] args) {
        String test = "123";

        MiStringQuestion util = new MiStringQuestion();
        util.SpiltString("", test);
        for (String tmp : out) {
            System.out.println(tmp);
        }
    }


    private boolean CheckNum(int value) {
        return (value > 0 && value < 27) ? true : false;
    }

    public void SpiltString(String resultString, String restString) {

        if (restString.length() == 0) {
            out.add(resultString);
        }

        if (restString.length() >= 1) {
            String shortSting = restString.substring(0, 1);
            int smallNum = Integer.valueOf(shortSting);
            if (CheckNum(smallNum)) {
                char smallChar = (char) ('a' + smallNum - 1);
                SpiltString(new String(resultString + smallChar), restString.substring(1));
            }
        }

        if (restString.length() >= 2) {
            String longString = restString.substring(0, 2);
            int bigNum = Integer.valueOf(longString);
            if (CheckNum(bigNum)) {
                char bigChar = (char) ('a' + bigNum - 1);
                SpiltString(new String(resultString + bigChar), restString.substring(2));
            }
        }
    }
}
