package com.github.vvzhuchkov.task02;

import java.util.List;

public class Calculator {

    public int calculator(String expression) {
        CheckExpression checkExpression = new CheckExpression();
        CalculationExpression calculationExpression = new CalculationExpression();
        checkExpression.checkIncorrectSymbols(expression);
        checkExpression.checkParenthesesQuantity(expression);
        checkExpression.checkParenthesesOrder(expression);
        checkExpression.checkEmptyParentheses(expression);
        checkExpression.checkSignBetweenParentheses(expression);
        checkExpression.checkCorrectSignOrder(expression);
        checkExpression.checkNegativeNumber(expression);
        checkExpression.checkStartEndSign(expression);
        String expWoutSpaces = checkExpression.checkSpaces(expression);
        calculationExpression.splitExp(expWoutSpaces);
        List<String> listOfNumb = calculationExpression.getOpNumb();
        int result = calculationExpression.calculation(listOfNumb);
        return result;
    }
}
