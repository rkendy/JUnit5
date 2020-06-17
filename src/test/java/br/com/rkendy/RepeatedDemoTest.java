package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.DisplayName;

class RepeatedDemoTest {

	@RepeatedTest(5)
	public void simpleRepeatedTest() {
		assertTrue(0 < 5);
	}

	@RepeatedTest(name = "{displayName} - {currentRepetition}/{totalRepetitions}", value = 5)
	@DisplayName("Repeated test")
	public void repeatedTestWithDisplayName() {
		assertTrue(0 < 5);
	}
}
