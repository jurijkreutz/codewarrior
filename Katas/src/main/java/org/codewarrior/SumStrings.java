package org.codewarrior;

import static java.lang.Integer.parseInt;

/*
This is a 4kyu Kata from Codewars.
"Given the string representations of two integers, return the string representation of the sum of those integers.
Use of BigInteger and BigDecimal is not allowed."
Link: https://www.codewars.com/kata/5324945e2ece5e1f32000370
 */

public class SumStrings {

    public String sumStrings(String a, String b) {
        int differenceInLength = a.length() - b.length();
        if (differenceInLength < 0) {
            differenceInLength = differenceInLength * (-1);
            a = addLeadingZeros(a, differenceInLength);

        } else if (differenceInLength > 0) {
            b = addLeadingZeros(b, differenceInLength);
        }
        char[] aNumbers = a.toCharArray();
        char[] bNumbers = b.toCharArray();
        int carryOver = 0;
        String result = "";
        for (int i = aNumbers.length-1; i >= 0; i--) {
            int currentResult = parseInt(String.valueOf(aNumbers[i]))
                    + parseInt(String.valueOf(bNumbers[i]))
                    + carryOver;
            if (currentResult > 9) {
                carryOver = 1;
                currentResult = parseInt(String.valueOf(Integer.toString(currentResult).charAt(1)));
            } else {
                carryOver = 0;
            }
            result = currentResult + result;
        }
        result = carryOver == 1 ? "1" + result : result;
        result = removeTrailingZeros(result);
        return result;
    }

    private String removeTrailingZeros(String result) {
        while (true) {
            if (result.charAt(0) == '0') {
                result = result.substring(1);
            }
            else {
                break;
            }
        }
        return result;
    }

    private String addLeadingZeros(String a, int differenceInLength) {
        StringBuilder aBuilder = new StringBuilder(a);
        for (int i = 0; i < differenceInLength; i++) {
            aBuilder.insert(0, "0");
        }
        return aBuilder.toString();
    }

}
