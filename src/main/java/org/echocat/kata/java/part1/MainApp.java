package org.echocat.kata.java.part1;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

  private static LibraryService libraryService = new LibraryService();

  public static void main(String[] args) {

    System.out.println("print publications");
    System.out.println(libraryService.getPublications());

    System.out.println("\n");
    System.out.println("print publications sorted by title");
    System.out.println(libraryService.getPublications());
  }

  protected static String getHelloWorldText() {
    return "Hello world!";
  }

}
