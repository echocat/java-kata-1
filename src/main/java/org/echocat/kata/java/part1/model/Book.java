package org.echocat.kata.java.part1.model;

import java.util.StringJoiner;

public class Book extends Publication {

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
        .add("isbn='" + super.getIsbn() + "'")
        .add("title='" + super.getTitle() + "'")
        .add("description='" + description + "'")
        .add("authors=" + super.getAuthors())
        .toString();
  }
}
