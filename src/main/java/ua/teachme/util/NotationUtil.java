package ua.teachme.util;

import ua.teachme.model.Notation;
import ua.teachme.model.NotationExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotationUtil {
    public static void main(String[] args) {
        List<Notation> notations = Arrays.asList(
                new Notation("name1", "URL", "description", 1, LocalDateTime.now()),
                new Notation("name2", "URL", "description", 4, LocalDateTime.now()),
                new Notation("name3", "URL", "description", 7, LocalDateTime.now()),
                new Notation("name4", "URL", "description", 2, LocalDateTime.now()),
                new Notation("name5", "URL", "description", 4, LocalDateTime.of(2016, Month.MARCH, 13, 11, 35)),
                new Notation("name6", "URL", "description", 1, LocalDateTime.of(2016, Month.MARCH, 13, 21, 55)),
                new Notation("name7", "URL", "description", 3, LocalDateTime.of(2016, Month.MARCH, 13, 22, 15)),
                new Notation("name8", "URL", "description", 0, LocalDateTime.of(2016, Month.MARCH, 13, 23, 31))
        );
        getFilteredNotationsWithExceed(notations, LocalTime.of(11, 0), LocalTime.of(23, 0), 8).forEach(System.out::println);
    }

    //filter with streams
    public static List<NotationExceed> getFilteredNotationsWithExceed(List<Notation> notations, LocalTime startTime, LocalTime endTime, int hoursPerDay){
        Map<LocalDate, Integer> hoursSumByDate = notations.stream()
                .collect(
                        Collectors.groupingBy(
                                notation -> notation.getDateTime().toLocalDate(),
                                Collectors.summingInt(Notation::getHours)
                        )
                );

        return notations.stream()
                .filter(notation -> TimeUtil.isBetween(notation.getTime(), startTime, endTime))
                .map(notation -> new NotationExceed(notation, hoursSumByDate.get(notation.getDate()) > hoursPerDay))
                .collect(Collectors.toList());
    }
}