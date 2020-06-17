package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * AssertArrayEqualsTest
 */
public class AssertArrayEqualsDemoTest {

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
    }

    @Test
    public void testAssertArrayEqualsForEqualArraysWithDifferentOrder() {
        int[] expected = { 1, 2, 4, 3 };
        int[] actual = { 1, 2, 3, 4 };
        assertNotEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}