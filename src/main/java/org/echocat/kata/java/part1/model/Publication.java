package org.echocat.kata.java.part1.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Publication implements PublicationIF {

  private String isbn;
  private String title;
  private Set<String> authorEmails;
  private Set<Author> authors;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void addAuthor(Author author) {
    if (authors == null) {
      authors = new HashSet<>();
    }
    authors.add(author);
  }

  public void setAuthorEmails(String[] authorEmails) {
    this.authorEmails = Arrays.stream(authorEmails).collect(Collectors.toSet());
  }

  public Set<String> getAuthorEmails() {
    return authorEmails;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  /**
   * publications are equal, if they have the same ISBN.
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Publication that = (Publication) o;
    return isbn.equals(that.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }

}
