package com.github.vvzhuchkov.task02;

import java.util.ArrayList;
import java.util.List;

public class LogicExp {

    private List<Character> operationStack = new ArrayList<>();
    private List<String> operationNumb = new ArrayList<>();
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
                divideByOp(expression.charAt(i));
            } else {
                operationNumb.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                divideByOp(expression.charAt(i));
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

    public void divideByOp(Character operation) {
        switch (operation) {
            case '(':
                operationStack.add(operation);
                break;
            case ')':
                if (!operationStack.contains('(')) {
                    System.out.println("Wrong entered expression!");
                    System.exit(0);
                }
                int findLastOpenParent = 0;
                for (int i = operationStack.size() - 1; i >= 0; i--) {
                    if (!operationStack.get(i).equals('(')) {
                        operationNumb.add(operationStack.get(i).toString());
                    } else {
                        operationStack.remove(i);
                    }
                }
                break;
            case '*':
                if (!operationStack.isEmpty() && (operationStack.get(operationStack.size() - 1).equals('-') || operationStack.get(operationStack.size() - 1).equals('+') ||
                        operationStack.get(operationStack.size() - 1).equals('*') || operationStack.get(operationStack.size() - 1).equals('/'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add('*');
                } else {
                    operationStack.add(operation);
                }
                break;
            case '/':
                if (!operationStack.isEmpty() && (operationStack.get(operationStack.size() - 1).equals('-') || operationStack.get(operationStack.size() - 1).equals('+') ||
                        operationStack.get(operationStack.size() - 1).equals('*') || operationStack.get(operationStack.size() - 1).equals('/'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add('/');
                } else {
                    operationStack.add(operation);
                }
                break;
            case '-':
                if (!operationStack.isEmpty() && (operationStack.get(operationStack.size() - 1).equals('-') || operationStack.get(operationStack.size() - 1).equals('+'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add('-');
                } else {
                    operationStack.add(operation);
                }
                break;
            case '+':
                if (!operationStack.isEmpty() && (operationStack.get(operationStack.size() - 1).equals('-') || operationStack.get(operationStack.size() - 1).equals('+'))) {
                    operationNumb.add(operationStack.get(operationStack.size() - 1).toString());
                    operationStack.remove(operationStack.size() - 1);
                    operationStack.add('+');
                } else {
                    operationStack.add(operation);
                }
                break;
            default:
                System.out.println("Wrong entered expression. Use numbers, parenthesis, division, multiplication, plus, minus. Try again!");
                System.exit(0);
        }
    }
}
