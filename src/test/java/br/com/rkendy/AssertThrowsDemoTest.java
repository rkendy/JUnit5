package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AssertThrowsDemoTest {
    @Test
    public void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> divide(1, 0));
    }

    private int divide(int a, int b) {
        return a / b;
    }
}