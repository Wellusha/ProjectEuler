package com.wellusha.FivePercentDiff;

import com.wellusha.Problem;

public class SpecialPythagoreanTriplet extends Problem {
    @Override
    public long returnValue(long initialValue) {
        double c;
        for (long a = 1; a < 1000; a++) {
            for (long b = a + 1; b < 1000; b++) {
               c = Math.sqrt(a * a + b * b);
               if ((b > a && c > b) && (a + b + c) == 1000)
                   return a * b * (long)c;
            }
        }
        return 0;
    }
}
