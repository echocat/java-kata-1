package org.echocat.kata.java.part1.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.time.LocalDate;
import java.util.Set;
import org.echocat.kata.java.part1.model.Magazine;
import org.junit.Test;

public class MagazineCsvReaderTest {

  @Test
  public void readAuthors() {
    Set<Magazine> magazines = MagazinCsvReader.readManazines("/org/echocat/kata/java/part1/data/magazines.csv");

    assertThat(magazines).isNotEmpty()
        .extracting("isbn", "title", "publishedAt")
        .contains(
            tuple("5454-5587-3210", "Beautiful cooking", LocalDate.of(2011, 5, 21)),
            tuple("2365-8745-7854", "Gourmet", LocalDate.of(2010, 6, 14)),
            tuple("4545-8541-2012", "My familie and me", LocalDate.of(2011, 7, 10)),
            tuple("2547-8548-2541", "The Wine Connoisseurs", LocalDate.of(2011, 12, 12)),
            tuple("1313-4545-8875", "Vinum", LocalDate.of(2012, 2, 23)),
            tuple("2365-5632-7854", "Cooking for gourmets", LocalDate.of(2012, 5, 1)));
  }
}