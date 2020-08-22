package org.echocat.kata.java.part1.util;

import org.echocat.kata.java.part1.book.domain.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.echocat.kata.java.part1.TestFixtures.testFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvEntityLoaderTest {

    @Test
    public void shouldLoadBookEntity() {
        CsvFileReader csvFileReader = new CsvFileReader();
        CsvEntityLoader csvEntityLoader = new CsvEntityLoader(csvFileReader);
        String filePath = testFile().getAbsolutePath();
        List<Book> books = csvEntityLoader.loadBooks(filePath);

        assertEquals(8, books.size());
    }
}