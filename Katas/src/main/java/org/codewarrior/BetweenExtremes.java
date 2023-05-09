package org.codewarrior;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
This is a 7kyu Kata from Codewars.
"Given an array of numbers, return the difference between the largest and smallest values."
Link: https://www.codewars.com/kata/56d19b2ac05aed1a20000430
 */

public class BetweenExtremes {

    // First attempt
    public int findDifferenceBetweenMaxAndMin(int[] numbers){
        int minNumber = Arrays.stream(numbers)
                .min()
                .orElseThrow(NoSuchElementException::new);
        int maxNumber = Arrays.stream(numbers)
                .max()
                .orElseThrow(NoSuchElementException::new);
        return maxNumber - minNumber;
    }

    // Second attempt
    public int findDifferenceBetweenMaxAndMinBySorting(int[] numbers){
        Arrays.sort(numbers);
        return numbers[numbers.length-1] - numbers[0];
    }
}
