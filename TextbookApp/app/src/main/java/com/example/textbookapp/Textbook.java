package com.example.textbookapp;

public class Textbook extends Book {
    private int copies;
    private String bankDetails;

    public Textbook(String title, String sellerName, int copies, double price, String bankDetails) {
        super(title, sellerName, price);
        this.copies = copies;
        this.bankDetails = bankDetails;
    }

    public int getCopies() { return copies; }
    public String getBankDetails() { return bankDetails; }

    @Override
    public String getDetails() {
        return title + " sold by " + sellerName + " for R" + price;
    }
}