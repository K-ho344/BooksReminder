package com.example.booksreminder;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Book book);

    @Query("DELETE FROM book_table")
    void deleteAll();

    @Query("SELECT * FROM book_table ORDER BY book ASC")
    LiveData<List<Book>> getAlphabetizedBooks();
}
