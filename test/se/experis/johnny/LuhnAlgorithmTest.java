package se.experis.johnny;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {

    private final LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();

    @Test
    void checkIfCreditCardTrue() {
        assertTrue(luhnAlgorithm.checkIfCreditCard(16));
    }

    @Test
    void checkIfCreditCardFalse(){
        assertFalse(luhnAlgorithm.checkIfCreditCard(20));
        assertFalse(luhnAlgorithm.checkIfCreditCard(15));
    }

    @Test
    void getExpectedIsEqual() {
        assertEquals(0,luhnAlgorithm.getExpectedValue(60));
        assertEquals(7,luhnAlgorithm.getExpectedValue(73));
    }

    @Test
    void getExpectedIsNotEqual(){
        assertNotEquals(4,luhnAlgorithm.getExpectedValue(69));
        assertNotEquals(1,luhnAlgorithm.getExpectedValue(80));
    }

    @Test
    void checkLuhnIsTrue() {
        assertTrue(luhnAlgorithm.checkLuhn("000000000000000" ,0));
        assertTrue(luhnAlgorithm.checkLuhn("511127917506452" ,1));
    }

    @Test
    void checkLuhnIsFalse(){
        assertFalse(luhnAlgorithm.checkLuhn("123603343112311" , 7));
        assertFalse(luhnAlgorithm.checkLuhn("511127917506452" , 5));
    }
}