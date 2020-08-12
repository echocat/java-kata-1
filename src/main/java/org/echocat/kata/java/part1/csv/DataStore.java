package org.echocat.kata.java.part1.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.Magazine;
import org.echocat.kata.java.part1.models.Medium;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class DataStore {

  private static final String AUTHORS_PATH = "authors.csv";
  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");


  private Map<String, Medium> mediumByIsbn;
  private Map<String, Author> authorsByEmail;
  public static final CSVParser CSV_PARSER = new CSVParserBuilder()
    .withSeparator(';')
    .withIgnoreQuotations(true)
    .build();

  public DataStore() {
    try (Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource(AUTHORS_PATH).toURI()))) {
      authorsByEmail = readAuthors(reader).stream()
        .collect(Collectors.toMap(Author::getEmail, identity()));
    } catch (IOException | URISyntaxException | CsvException e) {
      System.out.println("Couldn't read the authors");
      e.printStackTrace();
      authorsByEmail = Collections.emptyMap();
    }
  }

  public List<Author> getAllAuthors() {
    return Collections.unmodifiableList(new ArrayList<>(authorsByEmail.values()));
  }

  public Optional<Author> getAuthorByEmail(String email) {
    return Optional.ofNullable(authorsByEmail.get(email));
  }

  private List<Author> readAuthors(Reader reader) throws IOException, CsvException {
    CSVReader csvReader = initCsvReader(reader);

    return csvReader.readAll().stream()
      .map(this::toAuthor)
      .collect(Collectors.toList());
  }

  private List<Book> readBooks(Reader reader) throws IOException, CsvException {
    CSVReader csvReader = initCsvReader(reader);

    return csvReader.readAll().stream()
      .map(this::toBook)
      .collect(Collectors.toList());
  }

  private List<Magazine> readMagazines(Reader reader) throws IOException, CsvException {
    CSVReader csvReader = initCsvReader(reader);

    return csvReader.readAll().stream()
      .map(this::toMagazine)
      .collect(Collectors.toList());
  }

  private CSVReader initCsvReader(Reader reader) {
    return new CSVReaderBuilder(reader)
      .withSkipLines(1)
      .withCSVParser(CSV_PARSER)
      .build();
  }

  private Author toAuthor(String[] columns) {
    return Author.builder()
      .email(columns[0])
      .firstname(columns[1])
      .lastname(columns[2])
      .build();
  }

  private Book toBook(String[] columns) {
    return Book.builder()
      .title(columns[0])
      .isbn(columns[1])
      .authors(emailsToAuthors(columns[2]))
      .description(columns[2])
      .build();
  }

  private Magazine toMagazine(String[] columns) {
    return Magazine.builder()
      .title(columns[0])
      .isbn(columns[1])
      .authors(emailsToAuthors(columns[2]))
      .publishedAt(toDate(columns[2]))
      .build();
  }

  private List<Author> emailsToAuthors(String emailsStr) {
    return Stream.of(emailsStr.split(","))
      .map(email -> authorsByEmail.get(email))
      .collect(Collectors.toList());
  }

  private LocalDate toDate(String dateStr) {
    return LocalDate.parse(dateStr, DATE_FORMATTER);
  }
}
