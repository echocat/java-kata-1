package org.echocat.kata.java.part1.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public abstract class Publication implements PublicationIF {

  private String isbn;
  private String title;
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

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public void setAuthorEmails(String[] authorEmails) {
    this.authors = Arrays.stream(authorEmails).map(Author::new).collect(Collectors.toSet());
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

  @Override
  public String toString() {
    return new StringJoiner(", ", Publication.class.getSimpleName() + "[", "]")
        .add("isbn='" + isbn + "'")
        .add("title='" + title + "'")
        .add("authors=" + authors)
        .toString();
  }
}
