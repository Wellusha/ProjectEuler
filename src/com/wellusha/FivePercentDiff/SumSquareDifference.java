package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class SumSquareDifference extends Problem {
    @Override
    public long returnValue(long initialValue) {
        return squareSum(initialValue) - sumOfSquares(initialValue);
    }

    long sumOfSquares(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    long squareSum(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        return sum * sum;
    }
}
