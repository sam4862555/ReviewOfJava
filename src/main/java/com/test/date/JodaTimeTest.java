package com.test.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

/**
 * Created by szh on 2017/10/12.
 */
public class JodaTimeTest {

    public static void main(String[] args){

        DateTime dateTime = new DateTime();
        System.out.println("年 : " + dateTime.getYear()+"\n" +
                "月 : " + dateTime.getMonthOfYear()+"\n" +
                "日 : " + dateTime.getDayOfMonth()+"\n"
        );

    }

}


