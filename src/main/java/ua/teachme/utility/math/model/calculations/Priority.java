package ua.teachme.utility.math.model.calculations;

/*
    Priority class - determine operator priority.
*/
public class Priority {

    public static int determine(String token) {
        return priority(token);
    }

    private static int priority(String token) {
        switch (token) {
            case "^":
                return 0;
            case "*":
            case "/":
                return 1;
            case "+":
            case "-":
                return 2;
        }
        return 0;
    }
}
