package org.echocat.kata.java.part1.book.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String title;
    private String isbn;
    private String authors;
    private String description;
}
