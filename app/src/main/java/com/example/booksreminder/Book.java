package com.example.booksreminder;

import androidx.annotation.NonNull;

@Entity(tableName = "book_table")
public class Book {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "book")
    private String mBook;
    public Book(@NonNull String book){this.mBook = book;}
    public String getBook(){return this.mBook;}
}

