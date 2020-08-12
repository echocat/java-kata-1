package org.echocat.kata.java.part1.csv;

import org.echocat.kata.java.part1.models.Author;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DataStoreTest {

  private DataStore dataStore;
  @Before
  public void setUp() {
    this.dataStore = new DataStore();
  }

  @Test
  public void getAllAuthors() {
    List<Author> authors = dataStore.getAllAuthors();
    assertThat(authors.size(), is(6));
  }

  @Test
  public void getAuthorByEmail() {
    Author expected = Author.builder().email("null-ferdinand@echocat.org").firstname("Franz").lastname("Ferdinand").build();
    Optional<Author> authorByEmail = dataStore.getAuthorByEmail("null-ferdinand@echocat.org");
    assertTrue(authorByEmail.isPresent());
    assertThat(authorByEmail.get(), is(expected));
  }
}
