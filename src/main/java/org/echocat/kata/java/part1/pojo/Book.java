package org.echocat.kata.java.part1.pojo;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


@Data
@JsonPropertyOrder({"title","isbn","authors","description"})
public class Book {

    private String title;
    private String isbn;
    private Set<Author> authors;
    private String description;
}
