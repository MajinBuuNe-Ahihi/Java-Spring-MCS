package org.example;

import collection.CollectionLearn;
import thread.ThreadLearn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ThreadLearn.runOnThread();
            CollectionLearn cl = new CollectionLearn();
            cl.run();
        }catch (Exception ex) {
            System.out.println("Lỗi: "+ ex.toString());
        }
    }
}