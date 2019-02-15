import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void correctStringWithoutSpaces() {
        assertTrue(ValidatorUtils.isValid("2+8*9/10-10^11@2"));
    }

    @Test
    void correctStringWithSpacesInside(){
        assertTrue(ValidatorUtils.isValid("2       +      8     *       9    /   10   -   10   ^  11   @   2"));
    }

    @Test
    void correctStringStartingWithSpaces(){
        assertTrue(ValidatorUtils.isValid("         2+8*9/10-10^11@2"));
    }

    @Test
    void correctStringEndedWhitSpaces(){
        assertTrue(ValidatorUtils.isValid("2+8*9/10-10^11@2            "));
    }

    @Test
    void correctStringOnlyNumber(){
        assertTrue(ValidatorUtils.isValid("1234567890"));
    }

    @Test
    void wrongStringWithLetter(){
        assertFalse(ValidatorUtils.isValid("2A+8*9/10-10^11@2"));
    }

    @Test
    void wrongStringStartingWithSign(){
        assertFalse(ValidatorUtils.isValid("-2+8*9/10-10^11@2"));
    }

    @Test
    void wrongStringEndingWithSign(){
        assertFalse(ValidatorUtils.isValid("2+8*9/10-10^11@2-"));
    }

    @Test
    void wrongStringWithTwoSigns(){
        assertFalse((ValidatorUtils.isValid("2+8**9")));
    }


}