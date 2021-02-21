package org.echocat.kata.java.part1.service;


import java.util.List;

import org.echocat.kata.java.part1.pojo.Book;
import org.echocat.kata.java.part1.pojo.Magazine;


public class PrintingService {

    public void printAuthors() {
        //NOT REQUIRED
    }

    public void printBooks( List<Book> books ) {
        System.out.println( "-----------------------------------------------------------------------------" );
        System.out.printf( getPrintFormatForHeader(), "BOOK TITLE", "BOOK ISBN", "BOOK AUTHORS", "BOOK DESCRIPTION" );
        System.out.println();
        System.out.println( "-----------------------------------------------------------------------------" );

        books.stream().forEach( book -> System.out
                .format( getPrintFormatForData(), book.getTitle(), book.getIsbn(), book.getAuthors(), book.getDescription() ) );
        System.out.println( "-----------------------------------------------------------------------------" );

    }

    public void printMagazines( List<Magazine> magazines ) {

        System.out.println( "-----------------------------------------------------------------------------" );
        System.out.printf( getPrintFormatForHeader(), "MAGAZINE TITLE", "MAGAZINE ISBN", "MAGAZINE AUTHORS", "PUBLISHED AT" );
        System.out.println();
        System.out.println( "-----------------------------------------------------------------------------" );

        magazines.stream().forEach( magazine -> System.out
                .format( getPrintFormatForData(), magazine.getTitle(), magazine.getIsbn(), magazine.getAuthors(), magazine.getPublishedAt() ) );
        System.out.println( "-----------------------------------------------------------------------------" );

    }

    public void printBook( Book book ) {
        System.out.println( "-----------------------------------------------------------------------------" );
        System.out.printf( getPrintFormatForHeader(), "BOOK TITLE", "BOOK ISBN", "BOOK AUTHORS", "BOOK DESCRIPTION" );
        System.out.println();
        System.out.println( "-----------------------------------------------------------------------------" );

        System.out
                .format( getPrintFormatForData(), book.getTitle(), book.getIsbn(), book.getAuthors(), book.getDescription() );
        System.out.println( "-----------------------------------------------------------------------------" );

    }

    private String getPrintFormatForData(){
        return "%10s %30s %20s %5d";
    }

    private String getPrintFormatForHeader(){
        return "%10s %30s %20s %5s";
    }

}
