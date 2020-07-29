package com.company;

import java.util.HashSet;
import java.util.Set;

public class TriffleNumbers {
    private static final long MAX_THREE_POWER = 282429536481L;

    public static long t(long n) {
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (conditionsMet(i))
                sum += i;
        }
        return sum;
    }

    public static boolean conditionsMet(long num) {
        long numerator, denominator;
        numerator = omega(num);
        denominator = num;

        long gcdNum = gcd(numerator, denominator);
        while (gcdNum != 1) {
            numerator /= gcdNum;
            denominator /= gcdNum;
            gcdNum = gcd(numerator, denominator);
        }

        return isPowerOfThree(denominator);
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return (a);
        return gcd(b, a % b);
    }

    public static Set<Long> getDivisors(long num) {
        Set<Long> divisors = new HashSet<>();

        divisors.add(1L);
        for (long i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                divisors.add(i);
        }
        divisors.add(num);

        return divisors;
    }

    public static boolean isPowerOfThree(long num) {
        return MAX_THREE_POWER % num == 0;
    }

    public static long omega(long num) {
        Set<Long> divisors = getDivisors(num);
        long sum = 0;
        for (Long aLong : divisors) {
            sum += aLong;
        }
        return sum;
    }
}
