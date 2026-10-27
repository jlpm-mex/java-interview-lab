import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {
    ValidParentheses validParentheses;

    @BeforeEach
    public void setup(){
        validParentheses = new ValidParentheses();
    }

    @Test
    @DisplayName("Checking for true cases")
    public void isValidTestForOpenAndClose(){
        assertAll("Test cases like (), ([]), \"\"", ()->
                assertTrue(validParentheses.isValid("()")), () ->
                assertTrue(validParentheses.isValid("([])")), () ->
                assertTrue(validParentheses.isValid("")), () ->
                assertTrue(validParentheses.isValid("{}[]()")));
    }


    @Test
    @DisplayName("Checking for false cases ")
    public void isValidTestForNonClosing(){
        assertAll("Test cases like ({), ([]})", () ->
                assertFalse(validParentheses.isValid("({)")), () ->
                assertFalse(validParentheses.isValid("([]})")), () ->
                assertFalse(validParentheses.isValid("([)]")), ()->
                assertFalse(validParentheses.isValid("((()")), () ->
                assertFalse(validParentheses.isValid("()())")), () ->
                assertFalse(validParentheses.isValid("(((")));
    }

}
