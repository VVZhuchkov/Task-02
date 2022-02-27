package com.github.vvzhuchkov.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpression {

    public String checkSpaces(String expression) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            expression = matcher.replaceAll("");
        }
        return expression;
    }

    public void checkIncorrectSymbols(String expression) {
        if (Pattern.matches(".*[^\\s\\d-+*/()]+.*", expression)) {
            throw new RuntimeException("Incorrect symbols in your expression. " +
                    "Please use numbers, symbols + - * / and parentheses");
        }
    }

    public void checkCorrectSignOrder(String expression) {
        if (Pattern.matches(".*[-+*/][-+*/].*", expression)) {
            throw new RuntimeException("Incorrect signs order.");
        }
    }

    public void checkEmptyParentheses(String expression) {
        if (Pattern.matches(".*[(][)].*", expression)) {
            throw new RuntimeException("Incorrect expression! Empty parentheses.");
        }
    }

    public void checkSignBetweenParentheses(String expression) {
        if (Pattern.matches(".*[)][(].*", expression)) {
            throw new RuntimeException("Incorrect expression! Sign between parentheses was skipped.");
        }
    }

    public void checkNegativeNumber(String expression) {
        if (Pattern.matches("^[-]+[\\d]+.+", expression)) {
            throw new RuntimeException("Incorrect expression! Use only natural number!");
        }
        if (Pattern.matches(".*[(]+-+.+", expression)) {
            throw new RuntimeException("Incorrect expression! Use only natural number!");
        }
    }

    public void checkStartEndSign(String expression) {
        if (Pattern.matches("^[-+/*].+", expression)) {
            throw new RuntimeException("Incorrect expression! Expression can't start from sign!");
        }
        if (Pattern.matches(".*[-+/*]$", expression)) {
            throw new RuntimeException("Incorrect expression! Expression can't end from sign!");
        }
    }

    public void checkParenthesesQuantity(String expression) {
        char[] massExpress = expression.toCharArray();
        int count = 0;
        for (char express : massExpress) {
            if (express == '(') {
                count++;
            }
            if (express == ')') {
                count--;
            }
        }
        if (count != 0) {
            throw new RuntimeException("Incorrect expression. Odd parentheses quantity.");
        }
    }

    public void checkParenthesesOrder(String expression) {
        char[] massExpress = expression.toCharArray();
        int count = 0;
        for (char express : massExpress) {
            if (express == '(') {
                count++;
            }
            if (express == ')') {
                count--;
            }
            if (count < 0) {
                throw new RuntimeException("Incorrect expression. Wrong parenthesis order.");
            }
        }
    }
}
