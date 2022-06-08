package com.example.booksreminder;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private BookRepository mRepository;
    private final LiveData<List<Book>> mAllBooks;

    public BookViewModel(Application application) {
        super(application);
        mRepository = new BookRepository(application);
        mAllBooks = mRepository.getmAllBooks();
    }

    LiveData<List<Book>> getAllBooks() {return mAllBooks;}

    public void insert(Book book){mRepository.insert(book);}
}
