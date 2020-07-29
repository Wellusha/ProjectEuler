package com.wellusha;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class NumberSplitting {
    public class Task implements Callable<Long> {
        private long start;
        private long finish;
        public Task(long start, long finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public Long call() {
            long sum = 0;

            for (long i = start + 1; i <= finish; i++) {
                if (isS(i*i, i)) {
                    sum += i*i;
                }
            }

            return sum;
        }
    }
    long t(long n) throws ExecutionException, InterruptedException {
        long sum = 0;
        int threadNum = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        long root = (long)sqrt((double)n);
        long step = root / threadNum;
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
             futures.add(executorService.submit(new Task(step * i, step * (i + 1))));
        }
        for (int i = 0; i < threadNum; i++) {
            sum += futures.get(i).get();
        }
        executorService.shutdown();

        return sum;
    }

    int getNumberLength(long num) {
        int count = 0;
        long tmp = num;

        while(tmp > 0) {
            count++;
            tmp /= 10;
        }

        return count;
    }

    boolean isS(long num, long root) {
        int numberLength = getNumberLength(num);

        long rows = 1 << (numberLength - 1);
        long[] decimalPowers = new long[numberLength - 1];

        for (long i = 1; i < rows; i++) {
            int sum = 0;

            for (int j = 0; j < numberLength - 1; j++) {
                long bit = 1 << j;

                if ((i & bit) == bit) {
                    decimalPowers[j] = (long)pow(10d, j + 1);
                } else {
                    decimalPowers[j] = 0;
                }
            }

            long first, last;
            int k = numberLength - 2;
            while(decimalPowers[k] == 0)
                k--;
            last = decimalPowers[k];
            k = 0;
            while(decimalPowers[k] == 0)
                k++;
            first = decimalPowers[k];

            sum += (long)(num % first);
            sum += (long)(num / last);

            if (first != last) {
                long left, right;
                right = first;
                while (true) {
                    k++;
                    if (k > numberLength - 2)
                        break;
                    if (decimalPowers[k] == 0)
                        continue;
                    left = decimalPowers[k];
                    long tmp;
                    tmp = num % left;
                    sum += tmp / right;
                    right = left;
                }
            }

            if (sum == root)
                return true;
        }
        return false;
    }
}
