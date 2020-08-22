package org.echocat.kata.java.part1.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.util.exception.FileDoesNotExistException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader {
    private static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT.withDelimiter(';').withHeader().withSkipHeaderRecord();

    public List<CSVRecord> read(String filePath) throws FileDoesNotExistException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CSVParser parser = CSVParser.parse(reader, CSV_FORMAT);
            return parser.getRecords();
        } catch (IOException e) {
            throw new FileDoesNotExistException(filePath);
        }
    }
}
