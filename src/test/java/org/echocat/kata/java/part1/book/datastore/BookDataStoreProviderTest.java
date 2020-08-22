package org.echocat.kata.java.part1.book.datastore;

import org.echocat.kata.java.part1.book.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class BookDataStoreProviderTest {

    private ArrayList<Book> bookStore;

    private BookDataStoreProvider bookDataStoreProvider;

    @BeforeEach
    void setUp() {
        bookStore = new ArrayList<>();
        bookDataStoreProvider = new BookDataStoreProvider(bookStore);
    }

    @Test
    void shouldSaveBookToBookStore() {
        Book book = Book.builder()
                        .title("sample book title")
                        .build();
        bookDataStoreProvider.saveBook(book);
        assertThat(bookStore, contains(book));
    }
}