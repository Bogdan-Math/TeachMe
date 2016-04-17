package ua.teachme.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetween(LocalTime time, LocalTime startTime, LocalTime endTime) {
        return time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0;
    }


    public static String formatToString(LocalDateTime localDateTime){
        return localDateTime == null ? "" : localDateTime.format(DATE_TIME_FORMAT);
    }
}