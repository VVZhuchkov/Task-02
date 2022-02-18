package com.github.vvzhuchkov.task02;

import java.util.List;

public class OutputExp {


    public void outputDividedByOp (List<Character> expression){
        for(Character op : expression){
            System.out.print(op + " ");
        }
    }

    public void outputDividedByNumb (List<String> expression){
        for(String op : expression){
            System.out.print(op + " ");
        }
    }
}
