package ua.teachme.utility.math.model.calculations;

import java.util.List;

/*
    ListConverter class - convert List to String.
*/
public class ListConverter {

    public static String toString(List<String> outputTokens) {
        return String.join(" ", outputTokens);
    }

}
