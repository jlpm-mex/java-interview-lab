import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class FindFirstNonRepeatingTest {

    private FindFirstNonRepeating ffnr;

    @BeforeEach
    public void setup(){
        ffnr = new FindFirstNonRepeating();
    }

    @Test
    @DisplayName("Checking for the 'swiss' word, where w should be the answer")
    public void FirstNonRepeatingTestForSwiss(){
        char result = ffnr.firstNonRepeating("swiss");
        char result2 = ffnr.firstNonRepeatingTraditional("swiss");
        assertAll("Looking for first non repeated character", () ->
            assertEquals('w', result, "The resulting char is: "+result),
                () ->  assertEquals('w', result2, "The resulting char is: "+result2));
    }

    @Test
    @DisplayName("Checking for the 'aabbcdd' word, where c should be the answer")
    public void FirstNonRepeatingTestForAabbcdd(){
        char result = ffnr.firstNonRepeating("aabbcdd");
        char result2 = ffnr.firstNonRepeatingTraditional("aabbcdd");
        assertAll("Looking for first non repeated character", () ->
            assertEquals('c', result, "The result was: " + result),
                () ->
            assertEquals('c', result2, "The result was: " + result2));
    }


    @Test
    @DisplayName("Checking for the 'aabb' word, where there is no non-repeated character")
    public void FirstNonRepeatingTestForAabb(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeating("aabb");

        });
        Exception exceptionTraditional = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeatingTraditional("aabb");

        });

        assertAll("Looking for first non repeated character, where there is no non-repeated character", ()->
            assertEquals("String is empty, or there is no non repeated character", exception.getMessage() ),
                () ->
            assertEquals("String is empty, or there is no non repeated character", exceptionTraditional.getMessage() ));
    }

    @Test
    @DisplayName("Checking for empty String")
    public void FirstNonRepeatingTestForEmptyString(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeating("");
        });
        Exception exceptionTraditional = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeatingTraditional("");
        });
        assertAll("Empty String validation", ()->
            assertEquals("String is empty, or there is no non repeated character", exception.getMessage() ),
                () ->
            assertEquals("String is empty, or there is no non repeated character", exceptionTraditional.getMessage() ));
    }


    @Test
    @DisplayName("Checking for null")
    public void FirstNonRepeatingTestForNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeating(null);
        });
        Exception exceptionTraditional = assertThrows(IllegalArgumentException.class, () -> {
            ffnr.firstNonRepeatingTraditional(null);
        });
        assertAll("Null validation", () ->
            assertEquals("The string cant be null", exception.getMessage() ),
                () ->
            assertEquals("The string cant be null", exceptionTraditional.getMessage() ));
    }


    @Test
    @DisplayName("Checking for word 'aabccde'")
    public void FirstNonRepeatingTraditionalTestForAabccde(){
        assertAll( "Looking for first non repeated character", () ->
            assertEquals('b', ffnr.firstNonRepeating("aabccde")),
                () ->
            assertEquals('b', ffnr.firstNonRepeatingTraditional("aabccde")));
    }

}
