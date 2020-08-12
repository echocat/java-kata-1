package org.echocat.kata.java.part1.models;

import lombok.*;

import java.util.List;

@Getter
public class Book extends Medium {

  @NonNull
  private final String description;

  @Builder
  public Book(@NonNull String title,
              @NonNull String isbn,
              @NonNull List<Author> authors,
              @NonNull String description) {

    super(title, isbn, authors);
    this.description = description;
  }

  @Override
  protected MediumType getType() {
    return MediumType.BOOK;
  }
}
