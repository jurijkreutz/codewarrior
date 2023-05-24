package org.codewarrior;

import java.util.ArrayList;
import java.util.List;

public class Isograms {

    public boolean isIsogram(String word) {
        List<String> charList = new ArrayList<>();
        for (int i = 0; i < word.toCharArray().length; i++) {
            charList.add(String.valueOf(word.toCharArray()[i]));
        }
        for (int i = 0; i < charList.size(); i++) {
            List<String> newList = charList.subList(0, i);
            if (newList.stream().anyMatch(charList.get(i)::equalsIgnoreCase)) {
                return false;
            }
        }
        return true;
    }

}
