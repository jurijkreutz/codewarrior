import org.codewarrior.ParseInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParseIntTest {

    private final ParseInt service = new ParseInt();

    @ParameterizedTest
    @CsvSource({
            "ten, 10",
            "twenty, 20",
            "thirty, 30",
            "forty, 40",
            "fifty, 50",
            "sixty, 60",
            "seventy, 70",
            "eighty, 80",
            "ninety, 90"
    })
    void parseIntTens(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "one, 1",
            "two, 2",
            "three, 3",
            "four, 4",
            "five, 5",
            "six, 6",
            "seven, 7",
            "eight, 8",
            "nine, 9"
    })
    void parseIntSingleNumbers(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "eleven, 11",
            "twelve, 12",
            "ninety nine, 99",
            "eighty four, 84",
            "fifty five, 55",
            "seventy eight, 78",
            "forty two, 42"
    })
    void parseIntComplicatedTens(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "one hundred one, 101",
            "two hundred forty-six, 246",
            "five hundred fifty-four, 554",
            "nine hundred ninety-five, 995",
            "nine hundred nineteen, 919",
            "one hundred twelve, 112",
            "seven hundred twenty-four, 724",
            "nine hundred ninety-nine, 999"
    })
    void parseIntHundredsAndTens(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "one thousand, 1000",
            "two thousand four hundred fourteen, 2414",
            "two thousand four hundred forty-six, 2446",
            "three thousand one hundred sixty-nine, 3169",
            "six thousand two hundred fifty-four, 6254",
            "nine thousand nine hundred ninety-nine, 9999"
    })
    void parseIntThousands(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "ten thousand four hundred forty-six, 10446",
            "thirty thousand five hundred ten, 30510",
            "ninety thousand nine hundred ninety-nine, 90999",
            "ninety thousand eight hundred ninety-nine, 90899",
            "forty thousand three hundred fifty-four, 40354",
            "ninety nine thousand nine hundred ninety-nine, 99999",
            "eighty five thousand nine hundred ninety-nine, 85999",
            "six hundred and ninety-four thousand five hundred seventy-three, 694573",
            "nine hundred ninety-nine thousand nine hundred ninety-nine, 999999"
    })
    void parseIntTenThousands(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "seven hundred eighty-three thousand nine hundred and nineteen, 783919",
            "four hundred sixty-six thousand eight hundred and fifteen, 466815",
            "two hundred three thousand, 203000",
            "nine hundred ninety-nine thousand nine hundred ninety-nine, 999999",
            "one million, 1000000"
    })
    void parseIntHundredThousands(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "twenty five thousand three hundred seventy three, 25373",
            "fifty three thousand ninety-nine, 53099",
            "nine hundred fifty seven thousand eight hundred one, 957801",
            "three hundred ninety five thousand two hundred two, 395202"
    })
    void parseIntRandomNumbers(String stringToParse, int expectedResult) {
        int result = service.parseInt(stringToParse);

        Assertions.assertEquals(expectedResult, result);
    }

}
