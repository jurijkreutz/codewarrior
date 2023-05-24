package org.codewarrior;

public class HexToRGB {

    public int[] convertHexStringToRGB(String hex) {
        int[] result = new int[3];
        for (int i = 1; i < hex.length(); i++) {
            int index = 0;
            if (i > 2) { index = i < 5 ? 1 : 2; }
            result[index] = i%2 != 0 ? Character.getNumericValue(hex.charAt(i))*16
                    : result[index] + Character.getNumericValue(hex.charAt(i));
        }
        return result;
    }

}
