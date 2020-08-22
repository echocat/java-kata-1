package org.echocat.kata.java.part1.book.usecase;

import org.echocat.kata.java.part1.util.CsvEntityLoader;

public class LoadBooksFromCsvFromCsv implements LoadBooksFromCsvUseCase {
    private final CsvEntityLoader csvEntityLoader;

    public LoadBooksFromCsvFromCsv(CsvEntityLoader csvEntityLoader) {
        this.csvEntityLoader = csvEntityLoader;
    }

    @Override
    public void loadBooks() {
        // load books from csv
        // create books
    }
}
