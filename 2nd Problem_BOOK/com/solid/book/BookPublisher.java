package com.solid.book;


import java.util.List;

public class BookPublisher {
    public static void main(String[] args) {
        File book = new File("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToFile();
    }
}