package org.echocat.kata.java.part1.model;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Magazine extends Publication {

  private LocalDate publishedAt;

  public LocalDate getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(LocalDate publishedAt) {
    this.publishedAt = publishedAt;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Magazine.class.getSimpleName() + "[", "]")
        .add("isbn='" + super.getIsbn() + "'")
        .add("title='" + super.getTitle() + "'")
        .add("publishedAt='" + publishedAt + "'")
        .add("authors=" + (super.getAuthors() == null ? super.getAuthorEmails() : super.getAuthors()) + "]")
        .toString();
  }
}
