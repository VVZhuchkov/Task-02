package com.github.vvzhuchkov.task02;

import java.util.List;

public class OutputExp {

    public void outputPolandRec (List<String> expression){
        for(String op : expression){
            System.out.print(op + " ");
        }
    }

    public void outputResultExp (Integer result){
        System.out.println(result);
    }
}
