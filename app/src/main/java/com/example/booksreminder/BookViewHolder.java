package com.example.booksreminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private final TextView bookItemView;

    private BookViewHolder(View itemView){
        super(itemView);
        bookItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){
        bookItemView.setText(text);
    }

    static BookViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,parent,false);
        return new BookViewHolder(view);
    }
}
