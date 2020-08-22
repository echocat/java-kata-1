package org.echocat.kata.java.part1.book.datastore;

import org.echocat.kata.java.part1.book.domain.Book;
import org.echocat.kata.java.part1.book.usecase.CreateNewBookUseCase;

import java.util.List;

public class BookDataStoreProvider implements CreateNewBookUseCase {
    private final List<Book> bookStore;

    public BookDataStoreProvider(List<Book> bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public void saveBook(Book book) {
        bookStore.add(book);
    }
}
