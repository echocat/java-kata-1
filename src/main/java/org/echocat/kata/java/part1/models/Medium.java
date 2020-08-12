package org.echocat.kata.java.part1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Medium {
  protected final String title;
  protected final String isbn;
  protected final List<Author> authors;

  protected abstract MediumType getType();
}
