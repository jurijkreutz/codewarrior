import org.codewarrior.Isograms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsogramsTest {

    private final Isograms isogramService = new Isograms();

    // Simple Tests

    @Test
    public void isIsogram_isNotIsogram_ShouldReturnFalse() {
        String notAnIsogram = "isIsogram";

        boolean result = isogramService.isIsogram(notAnIsogram);

        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void isIsogram_isActuallyIsogram_ShouldReturnTrue() {
        String isogram = "Dermatoglyphics";

        boolean result = isogramService.isIsogram(isogram);

        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    // Parameterized Tests

    public static Stream<Arguments> isIsogram_ShouldReturnTrue() {
        return Stream.of(
                Arguments.of(true, "isogram"),
                Arguments.of(true, "abc"),
                Arguments.of(true, "thumbscrewjapingly"),
                Arguments.of(true, ""));
    }


    @ParameterizedTest
    @MethodSource
    public void isIsogram_ShouldReturnTrue(boolean expected, String input) {
        boolean result = isogramService.isIsogram(input);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> isIsogram_ShouldReturnFalse() {
        return Stream.of(
                Arguments.of(false, "blablah"),
                Arguments.of(false, "abba"),
                Arguments.of(false, "lol"),
                Arguments.of(false, "houses"));
    }

    @ParameterizedTest
    @MethodSource
    public void isIsogram_ShouldReturnFalse(boolean expected, String input) {
        boolean result = isogramService.isIsogram(input);

        Assertions.assertEquals(expected, result);
    }

}
