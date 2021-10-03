package com.solid.book;

import java.util.List;

public class BookReader {
    public static void main(String[] args) {
        Screen book = new Screen("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToScreen();
    }
}