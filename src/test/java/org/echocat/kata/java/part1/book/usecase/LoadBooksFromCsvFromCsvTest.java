package org.echocat.kata.java.part1.book.usecase;

import org.echocat.kata.java.part1.util.CsvEntityLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class LoadBooksFromCsvFromCsvTest {

    private CsvEntityLoader mockCsvEntityLoader = mock(CsvEntityLoader.class);

    private LoadBooksFromCsvFromCsv loadBooksFromCsvFromCsv;

    @BeforeEach
    void setUp() {
        loadBooksFromCsvFromCsv = new LoadBooksFromCsvFromCsv(mockCsvEntityLoader);
    }

    @Test
    void shouldCreate_N_BooksFromCsvWith_N_Records() {
    }
}

