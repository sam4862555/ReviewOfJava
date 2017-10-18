package com.test.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 * Created by szh on 2017/8/7.
 */
public class JodaTimeDateAndSimpleFormatConverter {

    public static void main(String[] args){

        //Original Version
        String date = "2016-07-03";
        SimpleDateFormat converter = new SimpleDateFormat("yyyy-MM-dd"); //Locale.CHINA
        SimpleDateFormat converter2 = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        try {
            Date ks = converter.parse(date);
            System.out.println(ks.getMonth());
            String time = converter2.format(ks);
            System.out.println(time);

        }catch (ParseException e){
            e.printStackTrace();
        }

        //JodaTime Version
        String timeString = "15/Apr/2017:00:00:02 +0800";
        DateTimeFormatter format = DateTimeFormat.forPattern("d/MMM/YYYY:H:m:s Z");
        DateTime date2 = DateTime.parse(timeString, format.withLocale(Locale.US));
        System.out.println(date2.toString());



    }

}
