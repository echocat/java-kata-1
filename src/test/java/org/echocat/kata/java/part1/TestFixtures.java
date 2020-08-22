package org.echocat.kata.java.part1;

import java.io.File;
import java.util.Objects;

public class TestFixtures {
    public static File testFile() {
        ClassLoader classLoader = TestFixtures.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource("test-books.csv")).getFile());
    }
}
