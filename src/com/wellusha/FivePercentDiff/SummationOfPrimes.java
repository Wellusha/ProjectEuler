package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class SummationOfPrimes extends Problem {
    @Override
    public long returnValue(long initialValue) {
        long sum = 0;
        for (long i = 0; i < initialValue; i++) {
            if(NthPrime.isPrime(i))
                sum += i;
        }
        return sum;
    }
}
