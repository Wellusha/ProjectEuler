package com.wellusha;

public class LargestPalindromeProduct extends Problem {
    @Override
    long returnValue(long initialValue) {
        long maxPalindrome = 0;
        long num;
        for (long i = initialValue; i < 1000; i++) {
            for (long j = initialValue; j < 1000; j++) {
                num = i * j;
                if (isPalindrome(num))
                    maxPalindrome = Math.max(maxPalindrome, num);
            }
        }
        return maxPalindrome;
    }

    boolean isPalindrome(long num) {
        String numStr = Long.toString(num);
        String reverse = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reverse);
    }
}
