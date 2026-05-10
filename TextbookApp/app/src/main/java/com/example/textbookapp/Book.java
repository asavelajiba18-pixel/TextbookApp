package com.example.textbookapp;

public abstract class Book {
    protected String title;
    protected String sellerName;
    protected double price;

    public Book(String title, String sellerName, double price) {
        this.title = title;
        this.sellerName = sellerName;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getSellerName() { return sellerName; }
    public double getPrice() { return price; }

    // Abstract method (must be implemented)
    public abstract String getDetails();
}