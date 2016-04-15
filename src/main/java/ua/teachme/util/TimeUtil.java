package ua.teachme.util;

import java.time.LocalTime;

public class TimeUtil {
    public static boolean isBetween(LocalTime time, LocalTime startTime, LocalTime endTime) {
        return time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0;
    }
}