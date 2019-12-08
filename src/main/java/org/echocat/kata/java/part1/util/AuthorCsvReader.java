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
import org.echocat.kata.java.part1.model.Author;

public class AuthorCsvReader {

  public static Set<Author> readAuthors(String authorsCsvFile) {

    try (InputStream is = AuthorCsvReader.class.getResourceAsStream(authorsCsvFile);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(isr)) {

      return readAuthors(bufferedReader);

    } catch (IOException e) {
      throw new RuntimeException("Unable to read from file " + authorsCsvFile, e);
    }
  }

  private static Set<Author> readAuthors(BufferedReader bufferedReader) {
    return bufferedReader.lines()
        .skip(1) // skip header
        .parallel()
        .map(lineParser())
        .collect(Collectors.toSet());
  }

  private static Function<String, Author> lineParser() {
    return line ->
    {
      String[] columns = line.split(";");
      Author author = new Author();
      author.setEmail(Objects.requireNonNull(columns[0], "Author must have an email: " + Arrays.toString(columns)));
      author.setFirstName(Objects.requireNonNull(columns[1]));
      author.setLastName(Objects.requireNonNull(columns[2]));
      return author;
    };
  }
}
