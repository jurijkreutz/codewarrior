import org.codewarrior.MostFrequentlyUsedWords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MostFrequentlyUsedWordsTest {

    private final MostFrequentlyUsedWords frequentWordsService = new MostFrequentlyUsedWords();

    @Test
    public void findTop3Words_SimpleCharacters_ShouldReturnCorrectArray() {
        String testString = "a a a  b  c c  d d d d  e e e e e";

        List<String> result = frequentWordsService.findTop3Words(testString);

        List<String> correctResult = Arrays.asList("e", "d", "a");
        Assertions.assertEquals(correctResult, result);
    }

    @Test
    public void findTop3Words_SpecialCharacters_ShouldReturnCorrectArray() {
        String testString = "  //wont won't won't ";

        List<String> result = frequentWordsService.findTop3Words(testString);

        List<String> correctResult = Arrays.asList("won't", "wont");
        Assertions.assertEquals(correctResult, result);
    }

    @Test
    public void findTop3Words_OnlyOneRelevantCharacter_ShouldReturnCorrectArray() {
        String testString = "  , e   .. ";

        List<String> result = frequentWordsService.findTop3Words(testString);

        List<String> correctResult = List.of("e");
        Assertions.assertEquals(correctResult, result);
    }

    @Test
    public void findTop3Words_OnlyIrrelevantCharacters_ShouldReturnEmptyArray() {
        String testString = "  ... ''' - ";

        List<String> result = frequentWordsService.findTop3Words(testString);

        List<String> correctResult = List.of();
        Assertions.assertEquals(correctResult, result);
    }

    @Test
    public void findTop3Words_LongText_ShouldReturnEmptyArray() {
        String testString = String.join("\n", "In a village of La Mancha, the name of which I have no desire to call to",
                "mind, there lived not long since one of those gentlemen that keep a lance",
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                "coursing. An olla of rather more beef than mutton, a salad on most",
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                "on Sundays, made away with three-quarters of his income.");

        List<String> result = frequentWordsService.findTop3Words(testString);

        List<String> correctResult = Arrays.asList("a", "of", "on");
        Assertions.assertEquals(correctResult, result);
    }

}
