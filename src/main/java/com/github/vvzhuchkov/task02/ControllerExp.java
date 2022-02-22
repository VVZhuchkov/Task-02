package com.github.vvzhuchkov.task02;

import java.util.List;

public class ControllerExp {

    public static void start() {
        InputExp inputExp = new InputExp();
        LogicExp logicExp = new LogicExp();
        OutputExp outputExp = new OutputExp();
        String expression = inputExp.inputExpression();
        logicExp.splitExp(expression);
        List<String> listOfNumb = logicExp.getOpNumb();
        outputExp.outputPolandRec(listOfNumb);
        outputExp.outputResultExp(logicExp.calculation(listOfNumb));
    }
}
