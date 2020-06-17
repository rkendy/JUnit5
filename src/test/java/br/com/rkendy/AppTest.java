package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void givenEvenNumber_whenIsEvenIsCalled_thenTrueIsReturned() {
        OddEven oddEven = new OddEven();
        assertTrue(oddEven.isNumberEven(10));
    }

    @Test
    void givenOddNumber_whenIsEvenIsCalled_thenFalseIsReturned() {
        OddEven oddEven = new OddEven();
        assertFalse(oddEven.isNumberEven(11));
    }

    @Test
    void givenNullString_whenReverseIsCalled_thenNullIsReturned() {
        String actual = StringUtils.reverse(null);
        assertNull(actual);
    }

    @Test
    void givenEmptyString_whenReverseIsCalled_thenEmptyStringShouldBeReturned() {
        String actual = StringUtils.reverse("");
        String message = "Actual String should be empty";
        assertEquals("", actual, message);
    }

    @Test
    void givenNonNullString_whenReversedIsCalled_thenReversedStringIsReturned() {
        String actual = StringUtils.reverse("ABCD");
        Supplier<String> messageSupplier = () -> "Actual String ABCD should be reversed to DCBA";
        assertEquals("DCBA", actual, messageSupplier);
    }

}
