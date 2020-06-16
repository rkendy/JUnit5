package br.com.rkendy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display name with spaces")
public class DisplayNameWithSpaces {

    @Test
    @DisplayName("Custom test name containing spaces")
    public void test() {
        System.out.println("test method got executed!!!");
    }

}