package com.jotish.octionltd.utils;

import java.util.Date;

/**
 * Created by jotishsuthar on 17/06/17.
 */

public class DateUtils {

  public static String getFormattedDifferenceInDates(Date startDate, Date endDate){
    long different = endDate.getTime() - startDate.getTime();
    long secondsInMilli = 1000;
    long minutesInMilli = secondsInMilli * 60;
    long hoursInMilli = minutesInMilli * 60;
    long daysInMilli = hoursInMilli * 24;

    long elapsedDays = different / daysInMilli;
    different = different % daysInMilli;

    long elapsedHours = different / hoursInMilli;
    different = different % hoursInMilli;

    long elapsedMinutes = different / minutesInMilli;
    different = different % minutesInMilli;
    long elapsedSeconds = different / secondsInMilli;

    String dateFormat = "";
    if (elapsedDays > 0) {
      dateFormat+= elapsedDays + "d";
    }

    if (elapsedHours > 0) {
      dateFormat+= " " + elapsedHours + "hr";
    }

    if (elapsedMinutes > 0) {
      dateFormat+= " " + elapsedMinutes + "min";
    }
    return dateFormat;
  }

}
