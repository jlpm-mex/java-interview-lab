import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsDuplicateTest {

    private ContainsDuplicate containsDuplicate;

    @BeforeEach
    public void setup(){
        containsDuplicate = new ContainsDuplicate();
    }

    @Test
    void hasDuplicatesThrowsWhenListIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> containsDuplicate.hasDuplicates(null)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "false, 1, 2, 3, 4",
            "true,  1, 2, 2, 4",
            "true,  5, 5, 5, 5",
            "true,  1, 2, 3, 1"
    })
    void hasDuplicatesReturnsExpectedResult(
            boolean expected,
            Integer a,
            Integer b,
            Integer c,
            Integer d) {

        List<Integer> values = Arrays.asList(a, b, c, d);

        assertEquals(expected, containsDuplicate.hasDuplicates(values));
    }

    @ParameterizedTest
    @MethodSource("specialCases")
    void hasDuplicatesReturnsResult(
            List<Integer> input,
            boolean expected) {

        assertEquals(expected, containsDuplicate.hasDuplicates(input));
    }

    static Stream<Arguments> specialCases() {
        return Stream.of(
                Arguments.of(List.of(), false),
                Arguments.of(Arrays.asList(null, 2, 3, null), true)
        );
    }
}
