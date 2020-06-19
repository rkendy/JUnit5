package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Run Tests with Tag "TagTwo":
 * $ mvn test -Dgroups="TagTwo"
 * 
 * Run Tests with Tags:
 * $ mvn test -Dgroups="TagOne,TagTwo"
 */

@Tag("TagTwo")
public class TagsTwoDemoTest {

    @Test
    void testTwo() {
        assertEquals(2, 2);
    }
    
}