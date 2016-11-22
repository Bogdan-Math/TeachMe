package ua.teachme.utility.math.model.calculations;

import java.util.*;

/*
    RPNotationManager class - manage string to RPN and calculate it.
    RPN - Reverse Polish Notation.
*/
public class RPNotationManager {

    public static String adaptExpression(String primaryExpression) {
        return primaryExpression.replace(" ", "");
    }

    public static String createNotation(String mathExpression) {

        List<String> outputTokens = new ArrayList<>();
        Stack<String> operatorsStack = new Stack<>();

        Set<String> basicOperators = Token.getOperatorsSet();
        String leftBracket = "(";
        String rightBracket = ")";
        basicOperators.add(leftBracket);
        basicOperators.add(rightBracket);

        int previousIndex = 0;
        boolean findNext = true;

        while (findNext) {
            int nextOperatorIndex = mathExpression.length();
            String nextOperator = "";
            for (String operator : basicOperators) {
                int i = mathExpression.indexOf(operator, previousIndex);
                if (i >= 0 && i < nextOperatorIndex) {
                    nextOperator = operator;
                    nextOperatorIndex = i;
                }
            }
            if (nextOperatorIndex == mathExpression.length()) {
                findNext = false;
            }
            else {
                if (previousIndex != nextOperatorIndex) {
                    outputTokens.add(mathExpression.substring(previousIndex, nextOperatorIndex));
                }
                if (nextOperator.equals(leftBracket)) {
                    operatorsStack.push(nextOperator);
                }
                else if (nextOperator.equals(rightBracket)) {
                    while (!operatorsStack.peek().equals(leftBracket)) {
                        outputTokens.add(operatorsStack.pop());
                        if (operatorsStack.empty()) {
                            throw new IllegalArgumentException("Unmatched brackets");
                        }
                    }
                    operatorsStack.pop();
                }
                else {
                    while (!operatorsStack.empty() && !operatorsStack.peek().equals(leftBracket) &&
                            (Priority.determine(nextOperator) >= Priority.determine(operatorsStack.peek()))) {
                        outputTokens.add(operatorsStack.pop());
                    }
                    operatorsStack.push(nextOperator);
                }
                previousIndex = nextOperatorIndex + nextOperator.length();
            }
        }

        if (previousIndex != mathExpression.length()) {
            outputTokens.add(mathExpression.substring(previousIndex));
        }

        while (!operatorsStack.empty()) {
            outputTokens.add(operatorsStack.pop());
        }

        return String.join(" ", outputTokens);
    }

    public static String calculateResult(String rpn) {

        StringTokenizer tokenizer = new StringTokenizer(rpn, " ");
        Stack<Double> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            if (!Token.getOperatorsSet().contains(token)) {
                stack.push(new Double(token));
            }
            else {
                Double operand2 = stack.pop();
                Double operand1 = stack.empty() ? 0.0d : stack.pop();

                switch (token) {
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                }
            }
        }

        return stack.pop().toString();
    }
}
