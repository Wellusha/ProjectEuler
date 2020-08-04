package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class NthPrime extends Problem {
    @Override
    public long returnValue(long initialValue) {
        long count = 0;
        long num = 0;
        while (count != initialValue) {
            num++;
            if (isPrime(num))
                count++;
        }
        return num;
    }

    static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
