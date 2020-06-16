package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;

@Disabled
public class DisabledClassTest {

    @Test
    void testMethod1() {
        assertTrue(4 > 0);
    }

    @Disabled("Skip in upper environments")
    @Test
    void testMethod2() {
        assertFalse(4 < 0);
    }

    @DisabledOnJre(JRE.JAVA_9)
    @Test
    void testDisableOnJava9() {
        assertFalse(10 > 40);
    }

    @DisabledIfSystemProperty(named = "os.name", matches = "Windows")
    @Test
    void testDisabledIfOperatingSystemMatchesWindows() {
        assertFalse(10 > 40);
    }

    @DisabledIfEnvironmentVariable(named = "HOME", matches = "/dummies/home")
    @Test
    void testDisabledIfHomeMatchesDummyDirectory() {
        assertFalse(10 > 40);
    }
}