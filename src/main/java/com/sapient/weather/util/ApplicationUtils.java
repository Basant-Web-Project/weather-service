package com.sapient.weather.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ApplicationUtils {


    public static String getLastDate(int dayCount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Using today's date
        c.add(Calendar.DATE, dayCount); // Adding 5 days
        return sdf.format(c.getTime());
    }

    public static List<String> forecastHealth(double maxTemp, Double windSpeed) {
        List<String> warnMessages = new ArrayList<>();
        if (maxTemp > 40) {
            warnMessages.add("Carry umbrella");
        }
        else if (windSpeed > 10) {
            warnMessages.add("It’s too windy, watch out!");
        }else{
            warnMessages.add("All good ! Enjoy");
        }
        return warnMessages;
    }
}
