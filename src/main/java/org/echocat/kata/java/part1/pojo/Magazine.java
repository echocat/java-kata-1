package org.echocat.kata.java.part1.pojo;


import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"title","isbn","authors","publishedAt"})
public class Magazine {

    private String title;
    private String isbn;
    private Set<Author> authors;
    private Date publishedAt;
}
