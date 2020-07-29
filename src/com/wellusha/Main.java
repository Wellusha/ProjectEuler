package com.wellusha;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TriffleNumbers triffleNumbers = new TriffleNumbers();
        System.out.println(triffleNumbers.t((long)Math.pow(10, 14)));
    }

}