package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.util.AuthorCsvReader;
import org.echocat.kata.java.part1.util.BooksCsvReader;
import org.echocat.kata.java.part1.util.MagazinCsvReader;

public class LibraryService {

  public Set<Publication> getPublications() {
    Map<String, Author> existingAuthors = AuthorCsvReader.readAuthors().stream().collect(Collectors.toMap(Author::getEmail, Function.identity()));
    Set<Book> books = BooksCsvReader.readBooks();
    Set<Magazine> magazines = MagazinCsvReader.readManazines();

    Set<Publication> publications = new HashSet<>();
    books.forEach(book -> {
      linkToAuthors(book, existingAuthors);
      publications.add(book);
    });

    magazines.forEach(magazine -> {
      linkToAuthors(magazine, existingAuthors);
      publications.add(magazine);
    });

    return publications;
  }

  private static void linkToAuthors(Publication publication, Map<String, Author> authors) {
    publication.getAuthorEmails().forEach(authorEmail -> publication.addAuthor(authors.get(authorEmail)));
  }

  public List<Publication> getPulicationsSortedByTitle() {
    return getPublications().stream().sorted(Comparator.comparing(Publication::getTitle)).collect(Collectors.toList());
  }

  public Set<Publication> findPublicationByAuthorEmail(String authorEmail) {
    return getPublications().stream().filter(publication -> publication.getAuthorEmails().contains(authorEmail)).collect(Collectors.toSet());
  }

  public Set<Publication> findPublicationByIsbn(String isbn) {
    return getPublications().stream().filter(publication -> publication.getIsbn().equals(isbn)).collect(Collectors.toSet());
  }
}
