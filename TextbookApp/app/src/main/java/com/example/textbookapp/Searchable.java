package com.example.textbookapp;

import java.util.ArrayList;

public interface Searchable {
    ArrayList<Textbook> search(String query);
}