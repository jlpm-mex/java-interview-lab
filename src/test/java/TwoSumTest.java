import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setup(){
        twoSum = new TwoSum();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void twoSumTest(int[] numbers, int target, int[] expected){
        assertArrayEquals(expected, twoSum.twoSum(numbers, target));
    }

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    public void twoSumInvalidTest(int[] numbers, int target, Class<RuntimeException> expected){
        assertThrows(expected, () -> twoSum.twoSum(numbers, target));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, 6, new int[] {1,3}), // Testing a valid result
                Arguments.of(new int[] {1,2,3,4}, 5, new int[] {1,2}), // Testing multiple valid solutions (first match)
                Arguments.of(new int[] {1,2,8,4,3}, 5, new int[] {0,3}), // Testing multiple valid solutions (first match)
                Arguments.of(new int[] {5,5}, 10, new int[] {0,1}), // Testing an array with exactly two elements
                Arguments.of(new int[] {1,2,10,10,3,6}, 20, new int[] {2,3}), // Testing a solution in the middle of the array
                Arguments.of(new int[] {-3,4,2,8}, 5, new int[] {0,3}), // Testing negative numbers
                Arguments.of(new int[] {0,4,3}, 3, new int[] {0,2}), // Testing a sum involving zero
                Arguments.of(new int[] {-3,-3}, -6, new int[] {0,1}), // Testing two negative numbers
                Arguments.of(new int[] {2,7,11,15}, 9, new int[] {0,1}), // Testing a solution at the beginning of the array
                Arguments.of(new int[] {1,3,5,7}, 12, new int[] {2,3}) // Testing a solution at the end of the array
        );
    }

    static Stream<Arguments> invalidTestCases(){
        return(
        Stream.of(
                Arguments.of(new int[] {1}, 3, IllegalArgumentException.class),
                Arguments.of(new int[] {}, 3, IllegalArgumentException.class),
                Arguments.of(null, 3, IllegalArgumentException.class),
                Arguments.of(new int [] {1,5}, 3, IllegalArgumentException.class)
            )
        );
    }


}
