package org.echocat.kata.java.part1.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Author {

  private String email;
  private String firstName;
  private String lastName;

  public Author() {
  }

  public Author(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Author author = (Author) o;
    return email.equals(author.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    if (firstName == null && lastName == null) {
      return email;
    }
    return new StringJoiner(", ", "", "")
        .add("email='" + email + "'")
        .add("firstName='" + firstName + "'")
        .add("lastName='" + lastName + "'")
        .toString();
  }
}
