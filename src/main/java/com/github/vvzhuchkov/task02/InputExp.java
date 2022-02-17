package com.github.vvzhuchkov.task02;

import java.util.Scanner;

public class InputExp {

    public String inputExpression(){
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression;
    }
}
