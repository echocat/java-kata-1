package org.echocat.kata.java.part1.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.echocat.kata.java.part1.model.Magazine;

public class MagazinCsvReader {

  static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.GERMANY);
  public static final String DEFAULT_REPOSITORY = "/org/echocat/kata/java/part1/data/magazines.csv";


  public static Set<Magazine> readManazines() {
    return readManazines(DEFAULT_REPOSITORY);
  }

  public static Set<Magazine> readManazines(String magazineCsvFile) {

    try (InputStream is = MagazinCsvReader.class.getResourceAsStream(magazineCsvFile);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(isr)) {

      return readMagazines(bufferedReader);

    } catch (IOException e) {
      throw new RuntimeException("Unable to read from file " + magazineCsvFile, e);
    }
  }

  private static Set<Magazine> readMagazines(BufferedReader bufferedReader) {
    return bufferedReader.lines()
        .skip(1) // skip header
        .parallel()
        .map(lineParser())
        .collect(Collectors.toSet());
  }

  private static Function<String, Magazine> lineParser() {
    return line ->
    {
      String[] columns = line.split(";");
      Magazine magazine = new Magazine();
      magazine.setTitle(Objects.requireNonNull(columns[0], "Book must have title: " + Arrays.toString(columns)));
      magazine.setIsbn(Objects.requireNonNull(columns[1], "Book must have isbn: " + Arrays.toString(columns)));
      magazine.setAuthorEmails(columns[2].split(","));
      magazine.setPublishedAt(LocalDate.parse(columns[3], DATE_FORMATTER));
      return magazine;
    };
  }
}
