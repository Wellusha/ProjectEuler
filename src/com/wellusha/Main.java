package com.wellusha;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TriffleNumbers triffleNumbers = new TriffleNumbers();
        Instant now = Instant.now();
        System.out.println(triffleNumbers.t((long)Math.pow(10, 14)));
        System.out.println("Operations took: " + Duration.between(now, Instant.now()).toMillis() + "ms");
    }

}