package org.echocat.kata.java.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainAppUnitTest {

    @Test
    public void testGetHelloWorldText() {
        assertEquals("Hello world!", MainApp.getHelloWorldText());
    }

}
