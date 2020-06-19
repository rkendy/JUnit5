package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Run Tests with Tag "TagOne":
 * $ mvn test -Dgroups="TagOne"
 * 
 * Run Tests with Tags:
 * $ mvn test -Dgroups="TagOne,TagTwo"
 */

@Tag("TagOne")
public class TagsOneDemoTest {

    @Test
    void testOne() {
        assertEquals(1, 1);
    }
    
    
}