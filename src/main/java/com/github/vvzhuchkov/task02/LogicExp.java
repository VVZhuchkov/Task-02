package com.github.vvzhuchkov.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicExp {

    private final List<Character> opStack = new ArrayList<>();
    private final List<String> opNumb = new ArrayList<>();
    private StringBuilder stringBuilder;

    public List<String> getOpNumb() {
        return opNumb;
    }

    public String checkSpaces(String expression) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            expression = matcher.replaceAll("");
        }
        return expression;
    }

    public void checkIncorrectSymbols (String expression){

    }

    public void checkOrderParentheses(String expression) {
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
            throw new RuntimeException("Incorrect expression. Wrong parenthesis order or quantity.");
        }
    }

    public void checkSymbOrder(String expression) {
        char[] massExpress = expression.toCharArray();
        Pattern pattern = Pattern.compile(".*[\\D].*");
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
            throw new RuntimeException("Incorrect expression. Wrong parenthesis order or quantity.");
        }
    }

    public void splitExp(String expression) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                divideByNumb(expression.charAt(i));
            } else if (stringBuilder.isEmpty()) {
                polandRec(expression.charAt(i));
            } else {
                opNumb.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                polandRec(expression.charAt(i));
            }
        }
        if (!stringBuilder.isEmpty()) {
            opNumb.add(stringBuilder.toString());
        }
        if (!opStack.isEmpty()) {
            for (int i = opStack.size() - 1; i >= 0; i--) {
                opNumb.add(opStack.get(i).toString());
            }
        }
    }

    public void divideByNumb(Character symbol) {
        stringBuilder.append(symbol);
    }

    public void polandRec(Character operation) {
        switch (operation) {
            case '(':
                opStack.add(operation);
                break;
            case ')':
                if (!opStack.contains('(')) {
                    System.out.println("Wrong entered expression!");
                    System.exit(0);
                }
                for (int i = opStack.size() - 1; i >= 0; i--) {
                    if (!opStack.get(i).equals('(')) {
                        opNumb.add(opStack.get(i).toString());
                        opStack.remove(i);
                    } else {
                        opStack.remove(i);
                        break;
                    }
                }
                break;
            case '*', '/':
                if (!opStack.isEmpty() && (opStack.get(opStack.size() - 1).equals('*') ||
                        opStack.get(opStack.size() - 1).equals('/'))) {
                    opNumb.add(opStack.get(opStack.size() - 1).toString());
                    opStack.remove(opStack.size() - 1);
                    opStack.add(operation);
                } else {
                    opStack.add(operation);
                }
                break;
            case '-', '+':
                if (!opStack.isEmpty() && ((opStack.get(opStack.size() - 1).equals('*')
                        || opStack.get(opStack.size() - 1).equals('/'))
                        || opStack.get(opStack.size() - 1).equals('-')
                        || opStack.get(opStack.size() - 1).equals('+'))) {
                    opNumb.add(opStack.get(opStack.size() - 1).toString());
                    opStack.remove(opStack.size() - 1);
                    opStack.add(operation);
                } else {
                    opStack.add(operation);
                }
                break;
            default:
                System.out.println("Wrong entered expression. Use numbers, parenthesis, " +
                        "division, multiplication, plus, minus. Try again!");
                System.exit(0);
        }
    }

    public int calculation(List<String> polandRec) {
        int result = 0;
        char sign;
        List<Integer> listForCalc = new ArrayList<>();
        for (String symbol : polandRec) {
            if (isDigit(symbol)) {
                listForCalc.add(Integer.parseInt(symbol));
            } else {
                int firstOp = listForCalc.get(listForCalc.size() - 2);
                int secondOp = listForCalc.get(listForCalc.size() - 1);
                sign = symbol.charAt(0);
                switch (sign) {
                    case '*' -> result = firstOp * secondOp;
                    case '/' -> result = firstOp / secondOp;
                    case '+' -> result = firstOp + secondOp;
                    case '-' -> result = firstOp - secondOp;
                    default -> {
                        System.out.println("Wrong entered expression. Use numbers, parenthesis, division, " +
                                "multiplication, plus, minus. Try again!");
                        System.exit(0);
                    }
                }
                listForCalc.remove(listForCalc.size() - 1);
                listForCalc.remove(listForCalc.size() - 1);
                listForCalc.add(result);
            }
        }
        return result;
    }


    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
