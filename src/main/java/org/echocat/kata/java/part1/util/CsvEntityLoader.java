package org.echocat.kata.java.part1.util;

import org.echocat.kata.java.part1.book.domain.Book;
import org.echocat.kata.java.part1.util.exception.FileDoesNotExistException;

import java.util.List;
import java.util.stream.Collectors;

public class CsvEntityLoader {
    private CsvFileReader csvFileReader;

    public CsvEntityLoader(CsvFileReader csvFileReader) {
        this.csvFileReader = csvFileReader;
    }

    public List<Book> loadBooks(String filePath) throws FileDoesNotExistException {
        return csvFileReader.read(filePath)
                                      .stream()
                                      .map(csvRecord -> Book.builder().build())
                                      .collect(Collectors.toList());
    }
}
