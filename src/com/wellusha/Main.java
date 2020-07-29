package com.wellusha;

import java.util.concurrent.ExecutionException;

import static java.lang.Math.pow;
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumberSplitting numberSplitting = new NumberSplitting();
        System.out.println("amount: " + numberSplitting.t((long)pow(10, 12)));
    }

}