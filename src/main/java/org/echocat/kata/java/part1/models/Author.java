package org.echocat.kata.java.part1.models;

import lombok.*;

@Builder
@Getter
@EqualsAndHashCode
public class Author {

  @NonNull
  String email;

  @NonNull
  String firstname;

  @NonNull
  String lastname;
}
