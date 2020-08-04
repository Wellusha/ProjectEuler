package com.wellusha;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Problem problem = new LargestPrimeFactor();
        System.out.println(problem.returnValue(600851475143L));
    }

}