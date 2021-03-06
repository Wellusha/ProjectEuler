package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class MultipleOfThreeAndFive extends Problem {
    boolean isFiveMult(long num) {
        return num % 5 == 0;
    }

    boolean isThreeMult(long num) {
        return num % 3 == 0;
    }

    @Override
    public long returnValue(long initialValue) {
        long sum = 0;
        for (int i = 2; i < initialValue; i++) {
            if (isThreeMult(i) || isFiveMult(i))
                sum += i;
        }
        return sum;
    }
}
