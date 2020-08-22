package org.echocat.kata.java.part1.book.usecase;

import org.echocat.kata.java.part1.book.domain.Book;

public interface CreateNewBookUseCase {
    void saveBook(Book book);
}
