package org.echocat.kata.java.part1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MainAppUnitTest {

  @Test
  public void testGetHelloWorldText() throws Exception {
    assertThat(MainApp.getHelloWorldText(), is("Hello world!"));
  }

}
