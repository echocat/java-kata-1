package org.echocat.kata.java.part1.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.echocat.kata.java.part1.model.Book;

public class BooksCsvReader {


  public static Set<Book> readBooks(String booksCsvFile) {

    try (InputStream is = BooksCsvReader.class.getResourceAsStream(booksCsvFile);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(isr)) {

      return readBooks(bufferedReader);

    } catch (IOException e) {
      throw new RuntimeException("Unable to read from file " + booksCsvFile, e);
    }
  }

  private static Set<Book> readBooks(BufferedReader bufferedReader) {
    return bufferedReader.lines()
        .skip(1) // skip header
        .parallel()
        .map(lineParser())
        .collect(Collectors.toSet());
  }

  private static Function<String, Book> lineParser() {
    return line ->
    {
      String[] columns = line.split(";");
      Book book = new Book();
      book.setTitle(Objects.requireNonNull(columns[0], "Book must have title: " + Arrays.toString(columns)));
      book.setIsbn(Objects.requireNonNull(columns[1], "Book must have isbn: " + Arrays.toString(columns)));
      book.setAuthorEmails(columns[2].split(","));
      book.setDescription(columns[3]);
      return book;
    };
  }
}
