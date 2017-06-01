package org.echocat.kata.java.part1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainAppUnitTest {

    @Test
    public void testGetHelloWorldText() throws Exception {
        assertThat(MainApp.getHelloWorldText(), is("Hello world!"));
    }

}
