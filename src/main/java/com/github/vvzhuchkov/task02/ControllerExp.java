package com.github.vvzhuchkov.task02;

import java.util.List;

public class ControllerExp {

    public void calculation(String expression) {
        LogicExp logicExp = new LogicExp();
        OutputExp outputExp = new OutputExp();
        logicExp.checkOrderParentheses(expression);
        logicExp.splitExp(expression);
        List<String> listOfNumb = logicExp.getOpNumb();
        outputExp.outputResultExp(logicExp.calculation(listOfNumb));
    }
}
