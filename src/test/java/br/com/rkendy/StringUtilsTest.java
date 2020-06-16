package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

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
