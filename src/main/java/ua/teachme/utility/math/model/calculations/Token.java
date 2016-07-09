package ua.teachme.utility.math.model.calculations;

import org.apache.commons.lang.math.NumberUtils;

import java.util.HashSet;
import java.util.Set;

/*
    Token class - checking entity.
    Check String to: Number, Operator, Function, String, Link.
*/
public class Token {

    private static final String OPERATORS = "^*/+-";

    public static boolean isNumber(String token) {
        return NumberUtils.isNumber(token);
    }

    public static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    public static boolean isFunction(String token) {
        return '=' == token.charAt(0);
    }

    public static boolean isString(String token) {
        return '\'' == token.charAt(0);
    }

    public static boolean isLink(String token) {
        return token.matches("^[A-Ja-j]([1-9]|1[0])$");
    }

    private static Set<String> operatorsSet;

    public static Set<String> getOperatorsSet() {
        createOperatorsSet();
        return operatorsSet;
    }

    private static void createOperatorsSet() {
        if (null == operatorsSet) {
            operatorsSet = new HashSet<>();
            for (int i = 0; i < OPERATORS.length(); i++) {
                operatorsSet.add(String.valueOf(OPERATORS.charAt(i)));
            }
        }
    }
}
