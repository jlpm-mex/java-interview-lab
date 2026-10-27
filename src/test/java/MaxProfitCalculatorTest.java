import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MaxProfitCalculatorTest {

    private MaxProfitCalculator maxProfitCalculator;

    @BeforeEach
    public void setup(){
        maxProfitCalculator = new MaxProfitCalculator();
    }

    @Test
    @DisplayName("Checking for special cases")
    public void specialCases(){
        assertAll("Special cases like one item, null, or empty",
                () -> assertThrows(IllegalArgumentException.class, () -> maxProfitCalculator.maxProfit(new int[] {})),
                () -> assertThrows(IllegalArgumentException.class, () -> maxProfitCalculator.maxProfit(null))
                );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void maxProfitTest(int[] input, int expected){
        assertEquals(expected, maxProfitCalculator.maxProfit(input));
    }

    static Stream<Arguments> testCases(){
        return(
                Stream.of(
                        Arguments.of(new int[]  {7,2,5,1,6},5),
                        Arguments.of(new int[] {7,2,5,1,3}, 3),
                        Arguments.of( new int[] {1,1,1}, 0),
                        Arguments.of( new int[] {1,2}, 1),
                        Arguments.of( new int[] {0,0,0}, 0),
                        Arguments.of( new int[] {7,6,4,3,1}, 0),
                        Arguments.of( new int[] {2,4,1}, 2),
                        Arguments.of( new int[] {1, 5, 3, 6}, 5),
                        Arguments.of( new int[] {1, 2, 3}, 2),
                        Arguments.of( new int[] {5,4}, 0),
                        Arguments.of( new int[]{1}, 0)
                )
        );
    }

}
