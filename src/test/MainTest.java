import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void correctCalculationAdd(){
        Calculate task = new Calculate("2+8");
        assertEquals(task.getResult(), "10.0");
    }

    @Test
    void correctCalculationMultiply(){
        Calculate task = new Calculate("2*8");
        assertEquals(task.getResult(), "16.0");
    }

    @Test
    void correctCalculationDivision(){
        Calculate task = new Calculate("8/2");
        assertEquals(task.getResult(), "4.0");
    }

    @Test
    void correctCalculationSubtraction(){
        Calculate task = new Calculate("8-2");
        assertEquals(task.getResult(), "6.0");
    }

    @Test
    void correctCalculationPow(){
        Calculate task = new Calculate("2^8");
        assertEquals(task.getResult(), "256.0");
    }

    @Test
    void correctCalculationRoot(){
        Calculate task = new Calculate("9@2");
        assertEquals(task.getResult(), "3.0");
    }

    @Test
    void correctCalculationWithOperationPriority(){
        Calculate task = new Calculate("2+9 ^ 2 - 8@3 + 2*5 + 10/5");
        assertEquals(task.getResult(), "93.0");
    }


}