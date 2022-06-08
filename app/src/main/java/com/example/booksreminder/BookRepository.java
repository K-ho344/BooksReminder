package com.example.booksreminder;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {

    private  BookDao mBookDao;
    private LiveData<List<Book>> mAllBooks;

    BookRepository(Application application){
        BookRoomDatabase db = BookRoomDatabase.getDatabase(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.getAlphabetizedBooks();
    }

    LiveData<List<Book>> getmAllBooks(){
        return mAllBooks;
    }

    void insert(Book book){
        BookRoomDatabase.databaseWriteExecutor.execute(()->{
            mBookDao.insert(book);
        });
    }

}
