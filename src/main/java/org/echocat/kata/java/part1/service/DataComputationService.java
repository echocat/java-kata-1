package org.echocat.kata.java.part1.service;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.echocat.kata.java.part1.pojo.Author;
import org.echocat.kata.java.part1.pojo.Book;
import org.echocat.kata.java.part1.pojo.Magazine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataComputationService {

    private static final String pathForAuthorsCsv = "src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
    private static final String pathForBooksCsv = "src/main/resources/org/echocat/kata/java/part1/data/books.csv";
    private static final String pathForMagazinesCsv = "src/main/resources/org/echocat/kata/java/part1/data/magazines.csv";

    private CsvReaderService csvReaderService;
    private PrintingService printingService;
    private FileReader fileReader;
    private List<Author> authors;
    private List<Book> books;
    private List<Magazine> magazines;

    public void computeAndDisplayData() throws IOException {
        fetchAndStoreDataFromCsv();
        printBookAndMagazineDetails();
    }

    public void fetchAndStoreDataFromCsv() throws IOException {

        File authorCsvFile = getFileFromPath( pathForAuthorsCsv );
        authors = csvReaderService.readAuthorCsvFile( authorCsvFile );

        File bookCsvFile = getFileFromPath( pathForBooksCsv );
        books = csvReaderService.readBookCsvFile( bookCsvFile );

        File magazineCsvFile = getFileFromPath( pathForMagazinesCsv );
        magazines = csvReaderService.readMagazineCsvFile( magazineCsvFile );

    }

    public void printBookAndMagazineDetails() {

        printingService.printBooks( books );
        printingService.printMagazines( magazines );
    }

    public void findBookByIsbn( String isbn ) {

        Optional<Book> bookOptional = books.stream()
                .filter( book -> book.getIsbn().equalsIgnoreCase( isbn ) )
                .findFirst();
        if( !bookOptional.isEmpty() ) {
            System.out.println("Requested Book is found.");
            printingService.printBook( bookOptional.get() );
        }
        else {
            System.out.println( "Requested Book is not Found" );
        }
    }

    private File getFileFromPath( final String pathVariable ) {
        return new File( pathVariable );
    }
}
