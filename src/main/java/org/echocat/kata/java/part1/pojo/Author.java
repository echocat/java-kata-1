package org.echocat.kata.java.part1.pojo;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


@Data
@JsonPropertyOrder({"email","firstname","lastname"})
public class Author {

    private String email;
    private String firstname;
    private String lastname;
}
