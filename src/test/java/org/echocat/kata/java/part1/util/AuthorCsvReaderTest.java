package org.echocat.kata.java.part1.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Set;
import org.echocat.kata.java.part1.model.Author;
import org.junit.Test;

public class AuthorCsvReaderTest {

  @Test
  public void readAuthors() {
    Set<Author> authors = AuthorCsvReader.readAuthors("/org/echocat/kata/java/part1/data/authors.csv");

    assertThat(authors).isNotEmpty()
        .extracting("email", "firstName", "lastName")
        .contains(
            tuple("null-lieblich@echocat.org", "Werner", "Lieblich"),
            tuple("null-rabe@echocat.org", "Harald", "Rabe"),
            tuple("null-gustafsson@echocat.org", "Karl", "Gustafsson"),
            tuple("null-mueller@echocat.org", "Max", "Müller"),
            tuple("null-walter@echocat.org", "Paul", "Walter"),
            tuple("null-ferdinand@echocat.org", "Franz", "Ferdinand")
        );
  }
}