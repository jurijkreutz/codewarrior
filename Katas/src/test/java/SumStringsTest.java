import org.codewarrior.BetweenExtremes;
import org.codewarrior.SumStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumStringsTest {

    private final SumStrings sumStringsService = new SumStrings();

    @Test
    void test() {
        String result = sumStringsService.sumStrings("0123", "456");

        String expected = "579";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void harderTest() {
        String result = sumStringsService.sumStrings("800", "9567");

        String expected = "10367";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void emptyStringTest() {
        String result = sumStringsService.sumStrings("", "547");

        String expected = "547";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void longTest() {
        String result = sumStringsService.sumStrings("11111111111111111111111111111111111", "2");

        String expected = "11111111111111111111111111111111113";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void ultraLongTest() {
        String result = sumStringsService.sumStrings("60166267611224662", "57118725150322312816760");

        String expected = "57118785316589924041422";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void unbelievableTest() {
        String result = sumStringsService.sumStrings("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111", "2");

        String expected = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111113";
        Assertions.assertEquals(expected, result);
    }

}
