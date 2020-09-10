package org.echocat.kata.java.part1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainAppUnitTest {

    @Test
    public void testGetHelloWorldText() {
        assertThat(MainApp.getHelloWorldText(), is("Hello world!"));
    }

}
