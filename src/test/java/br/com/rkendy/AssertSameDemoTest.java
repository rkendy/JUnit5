package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertSameDemoTest {
	@Test
	public void testAssertSameWithSameObject() {
		String actual = "hello";
		String expected = "hello";
		assertSame(expected, actual);
	}

	@Test
	public void testAssertSameWithDifferentObject() {
		String actual = new String("hello");
		String expected = new String("hello");

		assertNotSame(expected, actual);
	}

}
