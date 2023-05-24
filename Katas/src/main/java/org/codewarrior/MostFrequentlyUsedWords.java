package org.codewarrior;

/*
This is a 4kyu Kata from Codewars.
"Write a function that, given a string of text (possibly with punctuation and line-breaks),
returns an array of the top-3 most occurring words, in descending order of the number of occurrences."
Link: https://www.codewars.com/kata/51e056fe544cf36c410000fb
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentlyUsedWords {

    public List<String> findTop3Words(String text) {
        List<String> parts = Arrays.stream(text.toLowerCase().trim().split("[^a-zA-Z0-9']"))
                .filter(part -> !part.equals("") && part.matches(".*[a-zA-Z]+.*")).toList();
        Map<String, Long> wordFrequencies = parts
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> result = new ArrayList<>();
        while (result.size() < 3 && !wordFrequencies.isEmpty()) {
            Optional<Map.Entry<String, Long>> highestFrequency = wordFrequencies.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue());
            result.add(highestFrequency.get().getKey());
            wordFrequencies.remove(highestFrequency.get().getKey());
        }
        return result;
    }

}
