package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.model.PublicationIF;
import org.echocat.kata.java.part1.util.AuthorCsvReader;
import org.echocat.kata.java.part1.util.BooksCsvReader;
import org.echocat.kata.java.part1.util.MagazinCsvReader;

public class LibraryService {

  public Set<Publication> getPublications() {
    Set<Author> authors = AuthorCsvReader.readAuthors();
    Set<Book> books = BooksCsvReader.readBooks();
    Set<Magazine> magazines = MagazinCsvReader.readManazines();

    Set<Publication> publications = new HashSet<>();
    publications.addAll(books);
    publications.addAll(magazines);
    return publications;
  }

  public Set<Publication> getPulicationsSortedByTitle() {
    return (Set<Publication>) getPublications().stream().sorted(Comparator.comparing(Publication::getTitle));
  }
}
