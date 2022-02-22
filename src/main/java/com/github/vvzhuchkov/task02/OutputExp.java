package com.github.vvzhuchkov.task02;

import java.util.List;

public class OutputExp {

    public void outputPolandRec (List<String> expression){
        for(String op : expression){
            System.out.print(op + " ");
        }
        System.out.println();
    }

    public void outputResultExp (Integer result){
        System.out.println("The result of entered expression is: " + result);
    }
}
