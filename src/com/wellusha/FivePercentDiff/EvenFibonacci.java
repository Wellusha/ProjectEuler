package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class EvenFibonacci extends Problem {
    long findNext(long prevPrev, long prev) {
        return prevPrev + prev;
    }

    boolean isEven(long num) {
        return num % 2 == 0;
    }

    @Override
    public long returnValue(long initialValue) {
        long prevPrev = 1;
        long prev = 2;
        long num = findNext(prevPrev, prev);
        long sum = 2;
        while (num < initialValue) {
            if (isEven(num))
                sum += num;
            prevPrev = prev;
            prev = num;
            num = findNext(prevPrev, prev);
        }
        return sum;
    }
}
