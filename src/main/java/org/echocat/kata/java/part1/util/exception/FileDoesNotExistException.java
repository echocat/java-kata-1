package org.echocat.kata.java.part1.util.exception;

import static java.lang.String.format;

public class FileDoesNotExistException extends RuntimeException {
    public FileDoesNotExistException(String filePath) {
        super(format("Failed to read file : %s", filePath));
    }
}
