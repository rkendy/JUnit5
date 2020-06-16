package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * AssertArrayEqualsTest
 */
public class AssertArrayEqualsTest {

    @Test
    public void testAssertArrayEqualsForEqualArrays() {
        int[] expected = { 1, 2, 3, 4 };
        int[] actual = { 1, 2, 3, 4 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertArrayEqualsForNotEqualArrays() {
        int[] expected = { 1, 2, 3, 4 };
        int[] actual = { 1, 2, 3 };

        assertNotEquals(Arrays.toString(expected), Arrays.toString(actual));
        // assertArrayEquals(expected, actual, "Arrays are not equal.");
    }

    @Test
    public void testAssertArrayEqualsForEqualArraysWithDifferentOrder() {
        int[] expected = { 1, 2, 4, 3 };
        int[] actual = { 1, 2, 3, 4 };

        assertNotEquals(Arrays.toString(expected), Arrays.toString(actual));
        // assertArrayEquals(expected, actual, () -> "Arrays order is different");
    }
}