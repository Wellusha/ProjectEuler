package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class LargestPrimeFactor extends Problem {
    @Override
    public long returnValue(long initialValue) {
        long maxFactor = 2;
        while (initialValue % 2 == 0)
            initialValue /= 2;

        for (int i = 3; i <= Math.sqrt(initialValue); i += 2) {
            while (initialValue % i == 0) {
                maxFactor = Math.max(initialValue, maxFactor);
                initialValue /= i;
            }
        }

        if (initialValue > 2)
            maxFactor = initialValue;

        return maxFactor;
    }
}
