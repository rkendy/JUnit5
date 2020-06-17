package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class AssumeDemoTest {
    @Test
    void testOnDevelopmentEnvironment() {
        System.setProperty("ENV", "DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        // remainder of test will proceed
    }

    @Test
    void testOnProductionEnvironment() {
        System.setProperty("ENV", "PROD");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        // remainder of test will be aborted
    }

    @Test
    void testInAllEnvironments() {
        System.setProperty("ENV", "DEV");
        assumingThat("DEV".equals(System.getProperty("ENV")), () -> {
            // perform these assertions only on the Dev server
            System.out.println("Perform these assertions only on the Dev server !!!");
            assertEquals(2, 1 + 1);
        });

        // perform these assertions in all environments
        assertEquals(42, 40 + 2);
    }

    @Test
    void testInAllEnvironments2() {
        System.setProperty("ENV", "DEV");
        assumingThat("PROD".equals(System.getProperty("ENV")), () -> {
            // perform these assertions only on the Prod server
            System.out.println("Perform these assertions only on the Prod server !!!");
            assertEquals(2, 1 + 1);
        });

        // perform these assertions in all environments
        assertEquals(42, 40 + 2);
    }
}