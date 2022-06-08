package com.example.booksreminder;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "book")
    private String mBook;
    public Book(@NonNull String book){this.mBook = book;}
    public String getBook(){return this.mBook;}
}