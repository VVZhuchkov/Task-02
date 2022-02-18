package com.github.vvzhuchkov.task02;

import java.util.List;

public class ControllerExp {

    public static void start() {
        InputExp inputExp = new InputExp();
        LogicExp logicExp = new LogicExp();
        OutputExp outputExp = new OutputExp();
        String expression = inputExp.inputExpression();
        logicExp.splitExp(expression);
        List<Character> listOfOp = logicExp.getOperationStack();
        List<String> listOfNumb = logicExp.getOperationNumb();
        //outputExp.outputDividedByOp(listOfOp);
        outputExp.outputDividedByNumb(listOfNumb);
    }
}
