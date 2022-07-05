package com.example.booksreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 1;
    private BookViewModel mBookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final BookListAdapter adapter = new BookListAdapter(new BookListAdapter.BookDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        mBookViewModel.getAllBooks().observe(this,books -> {
            adapter.submitList(books);
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,NewBookActivity.class);
            startActivityForResult(intent,NEW_BOOK_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == NEW_BOOK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Book book = new Book(data.getStringExtra(NewBookActivity.EXTRA_REPLAY));
            mBookViewModel.insert(book);
        }else{
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}