package com.github.vvzhuchkov.task02;

import java.util.ArrayList;
import java.util.List;

public class LogicExp {

    private final List<Character> operationStack = new ArrayList<>();
    private final List<String> operationNumb = new ArrayList<>();
    private final List<Integer> listCalc = new ArrayList<>();
    private StringBuilder stringBuilder;

    public List<String> getOperationNumb() {
        return operationNumb;
    }

    public List<Character> getOperationStack() {
        return operationStack;
    }

    public void splitExp(String expression) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                divideByNumb(expression.charAt(i));
            } else if (stringBuilder.isEmpty()) {
                polandRec(expression.charAt(i));
            } else {
                operationNumb.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                polandRec(expression.charAt(i));
            }
        }
        if (!stringBuilder.isEmpty()) {
            operationNumb.add(stringBuilder.toString());
        }
        if (!operationStack.isEmpty()) {
            for (int i = operationStack.size() - 1; i >= 0; i--) {
                operationNumb.add(operationStack.get(i).toString());
            }
        }
    }

    public void divideByNumb(Character symbol) {
        stringBuilder.append(symbol);
    }

    public void polandRec(Character operation) {
        switch (operation) {
            case '(':
                operationStack.add(operation);
                break;
            case ')':
                if (!operationStack.contains('(')) {
                    System.out.println("Wrong entered expression!");
                    System.exit(0);
                }
                for (int i = operationStack.size() - 1; i >= 0; i--) {
                    if (!operationStack.get(i).equals('(')) {
                        operationNumb.add(operationStack.get(i).toString());
                        operationStack.remove(i);
                    } else {
                        operationStack.remove(i);
                    }
                }
                break;
            case '*', '/':
                if (!operationStack.isEmpty() && (operationStack.get(operationStack.size() - 1).equals('*') ||
                        operationStack.get(operationStack.size() - 1).equals('/'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add(operation);
                } else {
                    operationStack.add(operation);
                }
                break;
            case '-', '+':
                if (!operationStack.isEmpty() && ((operationStack.get(operationStack.size() - 1).equals('*')
                        || operationStack.get(operationStack.size() - 1).equals('/'))
                        || operationStack.get(operationStack.size() - 1).equals('-')
                        || operationStack.get(operationStack.size() - 1).equals('+'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add(operation);
                } else {
                    operationStack.add(operation);
                }
                break;
            default:
                System.out.println("Wrong entered expression. Use numbers, parenthesis, division, multiplication, plus, minus. Try again!");
                System.exit(0);
        }
    }

    public int calculation(List<String> polandRec) {
        int result = 0;
        char sign = '+';
   /*     for (int i = 0; i < polandRec.size(); i++) {
            if (isDigit(polandRec.get(i))) {
                listCalc.add(Integer.parseInt(polandRec.get(i)));
            } else {
                result = listCalc.get(i - 1) + sign + listCalc.get(i - 2);
            }
        }
        return result;*/
        /*for (int i = 0; i < polandRec.size(); i++) {
            if (!isDigit(polandRec.get(i))) {
                sign = polandRec.get(i).charAt(0);
                result = Integer.parseInt(polandRec.get(i - 1)) + Integer.parseInt(polandRec.get(i - 2));
            }
        }*/
        result = ;
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
