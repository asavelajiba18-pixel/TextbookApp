package com.example.textbookapp;

public class DuplicateBookException extends Exception {

    public DuplicateBookException(String message) {
        super(message);
    }
}