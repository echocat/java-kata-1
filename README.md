# Java Kata - Part 1: Library

Code kata in Java where you have to write a library of books and magazines.

[A code kata is an exercise in programming which helps a programmer hone their skills through practice and repetition.](https://en.wikipedia.org/wiki/Kata_(programming))

* [Topic](#topic)
* [Frame conditions](#frame-conditions)
* [Tasks](#tasks)
* [License](#license)

## Topic

You have to implement an abstracted and simple library system.

## Frame conditions

1. You have exact 2.5 hours of time - no minute longer.

   If you reach this time limit stop your work immediately.
   It is one part of the kata to respect this time limit.
   
2. There are no restrictions on how to use the provided time.
   If you want to code the entire time, take a break or a cigaret - it’s up to you.

3. This is a real world situation. You are allowed to consult the Internet, use every library you want, call a friend ...

   **BUT:** You are not allowed to do [pair programming](https://en.wikipedia.org/wiki/Pair_programming).
   **AND** If you have already done this kata before to have a look at your previous implementation.

4. Develop your code based on Java language level 8.

5. Keep the following priorities in mind while you implementing - in the mentioned order:
   1. Code quality
   2. Usage of object oriented methods
   3. Functionality

6. Given resources:

   > **Hint:** There is a reason why there are so many books and authors in german with [umlauts](https://en.wikipedia.org/wiki/Germanic_umlaut).

   * [`authors.csv`](src/main/resources/org/echocat/kata/java/part1/data/authors.csv): Contains authors with its `email`, `firstName` and `lastName`.
   * [`books.csv`](src/main/resources/org/echocat/kata/java/part1/data/books.csv): Contains books with its `title`, `description`, one or more `authors` and an `isbn`.
   * [`magazines.csv`](src/main/resources/org/echocat/kata/java/part1/data/magazines.csv): Contains magazines with its `title`, one or more `authors`, a `publishedAt` and an `isbn`.

## Tasks

* [Main tasks](#main-tasks)
* [Optional tasks](#optional-tasks)

### Main tasks

1. Your software should read all data from the given CSV files in a meaningful structure.

2. Print out all books and magazines (could be a GUI, console, …) with all their details (with a meaningful output format).

   > **Hint**: Do not call `printBooks(...)` first and then `printMagazines(...)` ;-)

3. Find a book or magazine by its `isbn`.

4. Find all books and magazines by their `authors`’ email.

5. Print out all books and magazines with all their details sorted by `title`.
   This sort should be done for books and magazines together.

### Optional tasks

> **Hint:** Optional means optional.

1. Write Unit tests for one or more methods.

2. Implement an interactive user interface for one or more of the main tasks mentioned above.
   This could be done by a website, on the console, etc.

3. Add a book and a magazine to the data structure of your software and export it to a new CSV files.

## License

See [LICENSE](LICENSE) file.
