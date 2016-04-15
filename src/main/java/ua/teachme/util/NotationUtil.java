package ua.teachme.util;

import ua.teachme.model.Notation;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class NotationUtil {
    public static void main(String[] args) {
        List<Notation> notations = Arrays.asList(
                new Notation("name1", "URL", "description", 1, LocalDateTime.now()),
                new Notation("name2", "URL", "description", 4, LocalDateTime.now()),
                new Notation("name3", "URL", "description", 7, LocalDateTime.now()),
                new Notation("name4", "URL", "description", 2, LocalDateTime.now()),
                new Notation("name5", "URL", "description", 4, LocalDateTime.of(2016, Month.MARCH, 13, 11, 35))
        );
        notations.forEach(System.out::println);
    }
}