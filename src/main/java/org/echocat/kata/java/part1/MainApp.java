package org.echocat.kata.java.part1;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

  private static LibraryService libraryService = new LibraryService();

  public static void main(String[] args) {

    System.out.println("print publications");
    libraryService.getPublications().forEach(System.out::println);

    System.out.println("\n");
    System.out.println("print publications sorted by title");
    libraryService.getPulicationsSortedByTitle().forEach(System.out::println);

    System.out.println("\n");
    System.out.println("find publication by authors email: null-mueller@echocat.org");
    libraryService.findPublicationByAuthorEmail("null-mueller@echocat.org").forEach(System.out::println);

    System.out.println("\n");
    System.out.println("find publication by isbn: 5454-5587-3210");
    libraryService.findPublicationByIsbn("5454-5587-3210").forEach(System.out::println);
  }

  protected static String getHelloWorldText() {
    return "Hello world!";
  }

}
