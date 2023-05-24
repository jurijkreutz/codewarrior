import org.codewarrior.HexToRGB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HexToRGBTest {

    private final HexToRGB hexToRGBService = new HexToRGB();


    public static Stream<Arguments> convertHexStringToRGB_CorrextHexStrings_ShouldReturnCorrectRGBStrings() {
        return Stream.of(
                Arguments.of(new int[] { 17,  17,  17}, "#111111"),
                Arguments.of(new int[] {  0,   0,   0}, "#000000"),
                Arguments.of(new int[] {255, 153,  51}, "#FF9933"),
                Arguments.of(new int[] {190, 173, 237}, "#beaded"),
                Arguments.of(new int[] {255, 255, 255}, "#FFFFFF"),
                Arguments.of(new int[] {250,  52,  86}, "#Fa3456"));
    }

    @ParameterizedTest
    @MethodSource
    public void convertHexStringToRGB_CorrextHexStrings_ShouldReturnCorrectRGBStrings(int[] expected, String input) {
        int[] result = hexToRGBService.convertHexStringToRGB(input);

        Assertions.assertArrayEquals(expected, result);
    }

}
