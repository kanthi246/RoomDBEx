package com.example.triviaapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String getOnlyDateString(String date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parsedDate = dateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(parsedDate.getTime());
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
            return dateFormat.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    public static String getOnlyTimeString(String date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parsedDate = dateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(parsedDate.getTime());
            dateFormat = new SimpleDateFormat("hh:mm a", Locale.US);
            return dateFormat.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }
}
