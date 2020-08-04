package com.wellusha;

public class SmallestMultiple extends Problem {
    @Override
    long returnValue(long initialValue) {
        boolean divisible;
        long num = 1;
        while (true) {
            divisible = true;
            for (long i = 1; i <= initialValue; i++) {
                if (num % i != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible)
                return num;
            num++;
        }
    }
}
