package com.wellusha;

import com.wellusha.FivePercentDiff.SummationOfPrimes;

public class Main {

    public static void main(String[] args) {
        Problem problem = new SummationOfPrimes();
        System.out.println(problem.returnValue(2000000));
    }

}