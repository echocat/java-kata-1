package org.echocat.kata.java.part1.service;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.echocat.kata.java.part1.pojo.Author;
import org.echocat.kata.java.part1.pojo.Book;
import org.echocat.kata.java.part1.pojo.Magazine;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CsvReaderService {

    private final CsvMapper csvMapper;

    public List<Author> readAuthorCsvFile( @NonNull final File authorCsvFile ) throws IOException {
        MappingIterator<Author> authorMappingIterator = csvMapper.readerWithTypedSchemaFor( Author.class ).readValues( authorCsvFile );

        return authorMappingIterator.readAll();
    }

    public List<Book> readBookCsvFile( @NonNull final File bookCsvFile ) throws IOException {
        MappingIterator<Book> bookMappingIterator = csvMapper.readerWithTypedSchemaFor( Book.class ).readValues( bookCsvFile );

        return bookMappingIterator.readAll();
    }

    public List<Magazine> readMagazineCsvFile( @NonNull final File magazineCsvFile ) throws IOException {
        MappingIterator<Magazine> magazineMappingIterator = csvMapper.readerWithTypedSchemaFor( Magazine.class ).readValues( magazineCsvFile );

        return magazineMappingIterator.readAll();
    }

}
