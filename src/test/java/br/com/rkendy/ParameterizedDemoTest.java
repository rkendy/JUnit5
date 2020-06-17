package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedDemoTest {

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 20 })
	void givenANumber_whenIsEvenIsCalled_thenTrueIsReturnedForEvenNumbers(int number) {
		OddEven oddEven = new OddEven();
		assertTrue(oddEven.isNumberEven(number));
	}

	@ParameterizedTest
	@EnumSource(Animal.class)
	void testEnumSource(Animal animal) {
		assertNotNull(animal);
	}

	@ParameterizedTest
	@MethodSource("parameterProvider")
	void testWithSimpleMethodSource(String argument) {
		// assertNotNull(argument);
		assertTrue(argument.startsWith("param"));
	}

	// method name is the source to test
	static Stream<String> parameterProvider() {
		return Stream.of("parameter1", "parameter2");
	}

	@ParameterizedTest
	@CsvSource({ "one, 1", "two, 2", "'foo, bar', 3" })
	void testWithCsvSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}

	@ParameterizedTest
	@CsvSource({ "one, " })
	void testWithCsvSource2(String first, String second) {
		assertNotNull(first);
		assertNull(second);
	}

	@ParameterizedTest
	@CsvSource({ "one, 'two,three'" })
	void testWithCsvSource3(String first, String second) {
		assertNotNull(first);
		assertEquals("two,three", second);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/capitals.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, String capital) {
		System.out.println(country + ": " + capital);
		assertNotNull(country);
		assertNotNull(capital);
	}

}
