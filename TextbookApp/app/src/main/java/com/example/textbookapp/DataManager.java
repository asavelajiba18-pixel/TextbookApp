package com.example.textbookapp;

import java.util.ArrayList;

public class DataManager {

    private static DataManager instance;
    private ArrayList<Textbook> books;

    private DataManager() {
        books = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    // NOW throws exception instead of boolean
    public void addBook(Textbook book) throws DuplicateBookException {

        for (Textbook b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle()) &&
                    b.getSellerName().equalsIgnoreCase(book.getSellerName())) {

                throw new DuplicateBookException("This book already exists for this seller.");
            }
        }

        books.add(book);
    }

    public ArrayList<Textbook> getBooks() {
        return books;
    }

    public ArrayList<Textbook> search(String query) {

        ArrayList<Textbook> results = new ArrayList<>();

        for (Textbook b : books) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    b.getSellerName().toLowerCase().contains(query.toLowerCase())) {

                results.add(b);
            }
        }

        return results;
    }
}