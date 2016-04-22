package ua.teachme.util.notation;

import ua.teachme.model.Notation;
import ua.teachme.dto.NotationExceed;
import ua.teachme.util.time.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class NotationUtil {

    public static final int HOURS_PER_DAY = 8;

    public static final List<Notation> NOTATIONS = Arrays.asList(
            new Notation("name1", "URL", "description", 1, LocalDateTime.now()),
            new Notation("name2", "URL", "description", 4, LocalDateTime.now()),
            new Notation("name3", "URL", "description", 7, LocalDateTime.now()),
            new Notation("name4", "URL", "description", 2, LocalDateTime.now()),
            new Notation("name5", "URL", "description", 4, LocalDateTime.of(2016, Month.MARCH, 13, 11, 35)),
            new Notation("name6", "URL", "description", 1, LocalDateTime.of(2016, Month.MARCH, 13, 21, 55)),
            new Notation("name7", "URL", "description", 3, LocalDateTime.of(2016, Month.MARCH, 13, 22, 15)),
            new Notation("name8", "URL", "description", 0, LocalDateTime.of(2016, Month.MARCH, 13, 23, 31))
    );

    public static void main(String[] args) {
        getFilteredNotationsExceedWithStreams(NOTATIONS, LocalTime.of(11, 0), LocalTime.of(23, 0), HOURS_PER_DAY).forEach(System.out::println);
        System.out.println("///////////////");
        getFilteredNotationsExceedWithLoops(NOTATIONS, LocalTime.of(11, 0), LocalTime.of(23, 0), HOURS_PER_DAY).forEach(System.out::println);
        System.out.println("///////////////");
        getFilteredWithExceed(NOTATIONS, HOURS_PER_DAY).forEach(System.out::println);
        System.out.println("///////////////");
    }

    //filter with full day period
    public static List<NotationExceed> getFilteredWithExceed(List<Notation> notations, int hoursPerDay){
        return getFilteredNotationsExceedWithStreams(notations, LocalTime.MIN, LocalTime.MAX, hoursPerDay);
    }

    //filter with streams
    public static List<NotationExceed> getFilteredNotationsExceedWithStreams(List<Notation> notations, LocalTime startTime, LocalTime endTime, int hoursPerDay){
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

    //filter with loops
    public static List<NotationExceed> getFilteredNotationsExceedWithLoops(List<Notation> notations, LocalTime startTime, LocalTime endTime, int hoursPerDay){
        Map<LocalDate, Integer> hoursSumByDate = new HashMap<>();
        notations.forEach(notation -> hoursSumByDate.merge(notation.getDate(), notation.getHours(), Integer::sum));

        List<NotationExceed> notationExceedList = new ArrayList<>();
        notations.forEach(notation -> {
            if (TimeUtil.isBetween(notation.getTime(), startTime, endTime)){
                notationExceedList.add( new NotationExceed(notation, hoursSumByDate.get(notation.getDate()) > hoursPerDay ));
            }
        });
        return notationExceedList;
    }
}