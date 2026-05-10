package com.example.textbookapp;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    EditText title, seller, copies, price, bank;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        title = findViewById(R.id.title);
        seller = findViewById(R.id.seller);
        copies = findViewById(R.id.copies);
        price = findViewById(R.id.price);
        bank = findViewById(R.id.bank);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {

            try {
                Textbook book = new Textbook(
                        title.getText().toString(),
                        seller.getText().toString(),
                        Integer.parseInt(copies.getText().toString()),
                        Double.parseDouble(price.getText().toString()),
                        bank.getText().toString()
                );

                DataManager.getInstance().addBook(book);

                Toast.makeText(this, "Book added!", Toast.LENGTH_SHORT).show();

            } catch (DuplicateBookException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}