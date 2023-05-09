import org.codewarrior.BetweenExtremes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BetweenExtremesTest {

    private final BetweenExtremes extremesService = new BetweenExtremes();

    @Test
    public void findDifferenceBetweenMaxAndMinBySorting_positiveNumbersTest() {
        int[] inputArray = new int[] {21, 34, 54, 43, 26, 12};

        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        int expected = 42;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findDifferenceBetweenMaxAndMin_NegativeNumbersTest() {
        int[] inputArray = new int[]{-1, -41, -77, -100};

        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        int expected = 99;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findDifferenceBetweenMaxAndMin_positiveAndNegativeNumbersTest() {
        int[] inputArray = new int[]{3, -41, -77, -100};

        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        int expected = 103;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findDifferenceBetweenMaxAndMin_zeroDifferenceTest() {
        int[] inputArray = new int[]{0, 0, 0};

        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        int expected = 0;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findDifferenceBetweenMaxAndMin_onlyOneNumber() {
        int[] inputArray = new int[]{0};

        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        int expected = 0;
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> findDifferenceBetweenMaxAndMinBySorting_randomTests() {
        return Stream.of(
                Arguments.of(200, new int[]{100, 2, 5, -100, 31, 83}),
                Arguments.of(97, new int[]{38, 43, 65, 98, 1, 9}),
                Arguments.of(4, new int[]{0, 0, 0, 1, -1, -3}),
                Arguments.of(13002, new int[]{12000, 13000, 0, -2}));
    }

    @ParameterizedTest
    @MethodSource
    public void findDifferenceBetweenMaxAndMinBySorting_randomTests(int expected, int[] inputArray) {
        int result = extremesService.findDifferenceBetweenMaxAndMinBySorting(inputArray);

        Assertions.assertEquals(expected, result);
    }

}
