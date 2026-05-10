package com.example.textbookapp;

// 🔽 REQUIRED IMPORTS
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private ArrayList<Textbook> books;

    public BookAdapter(ArrayList<Textbook> books) {
        this.books = books;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, seller;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.etSearch);
            seller = view.findViewById(R.id.etSearch);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Textbook book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.seller.setText(book.getSellerName());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}