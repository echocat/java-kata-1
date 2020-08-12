package org.echocat.kata.java.part1.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Magazine extends Medium {

  @Builder
  public Magazine(@NonNull String title,
                  @NonNull String isbn,
                  @NonNull List<Author> authors,
                  @NonNull LocalDate publishedAt) {

    super(title, isbn, authors);
    this.publishedAt = publishedAt;
  }

  @NonNull
  private final LocalDate publishedAt;

  @Override
  protected MediumType getType() {
    return MediumType.MAGAZINE;
  }
}
