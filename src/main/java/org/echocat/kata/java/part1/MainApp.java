package org.echocat.kata.java.part1;


import java.io.IOException;
import java.util.Scanner;

import org.echocat.kata.java.part1.service.DataComputationService;


public class MainApp {

    public static void main(String[] args) throws IOException {
        System.out.println(getHelloWorldText());

        //Reading Data from CSV and Printing necessary details
        DataComputationService dataComputationService = new DataComputationService();
        dataComputationService.computeAndDisplayData();

        Scanner sc = new Scanner( System.in );
        System.out.println("Please enter an ISBN for a Book");
        String isbn = sc.next();
        //Finding a book by its ISBN
        dataComputationService.findBookByIsbn( isbn );

    }

    protected static String getHelloWorldText() {
        return "Hello world!";
    }

}
