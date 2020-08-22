package org.echocat.kata.java.part1.util;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.util.exception.FileDoesNotExistException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.echocat.kata.java.part1.TestFixtures.testFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvFileReaderTest {

    @Test
    public void shouldReadCsvFromGivenFilePath() {
        CsvFileReader csvFileReader = new CsvFileReader();
        String filePath = testFile().getAbsolutePath();
        List<CSVRecord> records = csvFileReader.read(filePath);

        assertEquals(8, records.size());
    }

    @Test
    public void shouldThrowFileNotFoundException() {
        CsvFileReader csvFileReader = new CsvFileReader();
        assertThrows(FileDoesNotExistException.class, () -> csvFileReader.read("non-existing-file.csv"));
    }
}