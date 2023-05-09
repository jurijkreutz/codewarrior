package org.codewarrior;

/*
This is a 4kyu Kata from Codewars.
"In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
Examples:
"one" => 1
"twenty" => 20
"two hundred forty-six" => 246
"seven hundred eighty-three thousand nine hundred and nineteen" => 783919
"
Link: https://www.codewars.com/kata/525c7c5ab6aecef16e0001a5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseInt {

    private HashMap<String, Integer> numData = new HashMap<>();

    public ParseInt() {
        this.initialize();
    }

    public int parseInt(String numStr) {
        String[] splitted = numStr.split("[ -]");
        if (numStr.contains("million")) {
            return 1000000;
        }
        int result;
        if (splitted.length > 1) {
            List<Integer> numbers = new ArrayList<>();
            for (String numString : splitted) {
                numbers.add(numData.get(numString));
            }
            result = calculateCorrectNumber(numbers);
        }
        else {
            result = numData.get(numStr);
        }
        return result;
    }


    private int calculateCorrectNumber(List<Integer> numbers) {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            // if number is 100, check if multiply by previous single number
            if (numbers.get(i) == 100) {
                if (i != 0) {
                    result += (100 * numbers.get(i-1));
                } else {
                    result += 100;
                }
            }
            // if number is in the tens, add to result
            else if (numbers.get(i)%10 == 0 && numbers.get(i) < 100) {
                result += numbers.get(i);
            }
            // if number is single number where ten is before, just add to result
            else if (i != 0 && numbers.get(i) < 10 && numbers.get(i-1)%10 == 0 && numbers.get(i-1) < 100) {
                result += numbers.get(i);
            }
            // if number is single number where hundred is before, just add to result
            else if (i != 0 && numbers.get(i) < 10 && numbers.get(i-1)%100 == 0 && numbers.get(i-1) < 1000) {
                result += numbers.get(i);
            }
            // if number is thousand, multiply previous result * 1000
            else if (numbers.get(i) == 1000) {
                if (i == 1) {
                    result = numbers.get(0)*1000;
                }
                else {
                    result *= 1000;
                }
            }
            // if number is at the end, just add to result
            else if (i == numbers.size()-1) {
                result += numbers.get(i);
            }
        }
        return result;
    }


    private void initialize() {

        // single character numbers
        numData.put("zero", 0);
        numData.put("one", 1);
        numData.put("two", 2);
        numData.put("three", 3);
        numData.put("four", 4);
        numData.put("five", 5);
        numData.put("six", 6);
        numData.put("seven", 7);
        numData.put("eight", 8);
        numData.put("nine", 9);

        // tens
        numData.put("ten", 10);
        numData.put("twenty", 20);
        numData.put("thirty", 30);
        numData.put("forty", 40);
        numData.put("fifty", 50);
        numData.put("sixty", 60);
        numData.put("seventy", 70);
        numData.put("eighty", 80);
        numData.put("ninety", 90);

        // hundred
        numData.put("hundred", 100);

        // thousand
        numData.put("thousand", 1000);

        // and
        numData.put("and", 0);

        // 11 - 19
        numData.put("eleven", 11);
        numData.put("twelve", 12);
        numData.put("thirteen", 13);
        numData.put("fourteen", 14);
        numData.put("fifteen", 15);
        numData.put("sixteen", 16);
        numData.put("seventeen", 17);
        numData.put("eighteen", 18);
        numData.put("nineteen", 19);
    }

}
