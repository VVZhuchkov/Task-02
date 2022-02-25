package com.github.vvzhuchkov.task02;

public class Input {
    public static void main(String[] args) {
        String expression = "   ( 2+ 2)";
        LogicExp logicExp = new LogicExp();
        System.out.println(logicExp.checkSpaces(expression));
        //logicExp.checkQuantityParentheses(expression);
        logicExp.checkOrderParentheses(expression);
    }
}
