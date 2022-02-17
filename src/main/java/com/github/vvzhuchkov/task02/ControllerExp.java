package com.github.vvzhuchkov.task02;

public class ControllerExp {

    public void start(){
        InputExp inputExp = new InputExp();
        LogicExp logicExp = new LogicExp();
        OutputExp outputExp = new OutputExp();
        String expression = inputExp.inputExpression();
        logicExp.divideByParenthesis(expression);
    }
}
