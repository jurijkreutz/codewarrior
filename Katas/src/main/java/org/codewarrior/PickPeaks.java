package org.codewarrior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This is a 5kyu Kata from Codewars.
"In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.
For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5)."
Link: https://www.codewars.com/kata/5279f6fe5ab7f447890006a7
 */

public class PickPeaks {

    public Map<String,List<Integer>> getPeaks(int[] arr) {
        List<Integer> positions = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();
        int plateauNumber = 0;
        int plateauPosition = 0;
        boolean isPlateau = false;
        for (int i = 1; i < arr.length-1; i++) {
            if (isSimplePeak(arr, i)) {
                positions.add(i);
                peaks.add(arr[i]);
            }
            if (isBeginningOfPlateau(arr, i)) {
                plateauPosition = i;
                plateauNumber = arr[i];
                isPlateau = true;
            }
            if (isPlateau && nextPositionHigher(arr, i)) {
                isPlateau = false;
            }
            if (nextPositionLower(arr, i) && isPlateau) {
                positions.add(plateauPosition);
                peaks.add(plateauNumber);
                isPlateau = false;
            }
        }
        HashMap<String, List<Integer>> result = new HashMap<>();
        result.put("pos", positions);
        result.put("peaks", peaks);
        return result;
    }

    private boolean nextPositionLower(int[] arr, int i) {
        return arr[i] > arr[i + 1];
    }

    private boolean nextPositionHigher(int[] arr, int i) {
        return arr[i] < arr[i + 1];
    }

    private boolean isBeginningOfPlateau(int[] arr, int i) {
        return arr[i - 1] < arr[i] && arr[i] == arr[i + 1];
    }

    private boolean isSimplePeak(int[] arr, int i) {
        return arr[i - 1] < arr[i] && arr[i + 1] < arr[i];
    }

}
