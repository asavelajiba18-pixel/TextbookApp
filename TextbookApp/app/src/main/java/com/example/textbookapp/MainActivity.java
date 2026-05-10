package com.example.textbookapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private Button btnSearch;
    private RecyclerView recyclerView;

    private ArrayList<Textbook> textbookList;
    private ArrayList<Textbook> filteredList;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerViewTextbooks);

        // Data setup
        textbookList = new ArrayList<>();
        filteredList = new ArrayList<>();

        seedData();

        // start with full list displayed
        filteredList.addAll(textbookList);

        // RecyclerView setup
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter(filteredList);
        recyclerView.setAdapter(adapter);

        // Search logic
        btnSearch.setOnClickListener(v -> {
            String query = etSearch.getText().toString().trim();
            searchTextbooks(query);
        });
    }

    private void seedData() {
        textbookList.add(new Textbook("Maths 101", "John", 5, 250.0, "123456"));
        textbookList.add(new Textbook("Physics Basics", "Sarah", 2, 300.0, "987654"));
        textbookList.add(new Textbook("Computer Science", "Mike", 10, 400.0, "555111"));
    }

    private void searchTextbooks(String query) {

        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(textbookList);
        } else {
            for (Textbook t : textbookList) {
                if (t.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(t);
                }
            }
        }

        adapter.notifyDataSetChanged();
    }
}