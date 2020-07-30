package com.wellusha;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TriffleNumbers {
    private static final long MAX_THREE_POWER = 205891132094649L;

    public class Task implements Callable<Long> {
        private long start, finish;
        public Task(long start, long finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (long i = start + 1; i <= finish; i++) {
                if (conditionsMet(i))
                    sum += i;
            }
            return sum;
        }
    }

    public long t(long n) throws ExecutionException, InterruptedException {
        int theadN = 10;
        long step = n / theadN;
        long sum = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(theadN);
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < theadN; i++) {
            futures.add(executorService.submit(new Task(step * i, step * (i + 1))));
        }
        for (int i = 0; i < theadN; i++) {
            sum += futures.get(i).get();
        }
        executorService.shutdown();

        return sum;
    }

    public boolean conditionsMet(long num) {
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

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public boolean isPowerOfThree(long num) {
        if (num == 1) return false;
        return MAX_THREE_POWER % num == 0;
    }

    public long omega(long num) {
        long sum = 1;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i)
                    sum += i;
                else {
                    sum += i;
                    sum += num / i;
                }
            }
        }
        sum += num;

        return sum;
    }
}
