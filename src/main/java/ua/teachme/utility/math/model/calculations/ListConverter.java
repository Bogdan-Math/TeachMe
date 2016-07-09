package ua.teachme.utility.math.model.calculations;

import java.util.List;

/*
    ListConverter class - convert List to String.
*/
public class ListConverter {

    public static String toString(List<String> outputTokens) {

        StringBuilder result = new StringBuilder();

        if (!outputTokens.isEmpty())
            result.append(outputTokens.remove(0));

        while (!outputTokens.isEmpty())
            result.append(" ").append(outputTokens.remove(0));

        return result.toString();
    }

}
