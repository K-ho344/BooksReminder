package com.example.booksreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewBookActivity extends AppCompatActivity {

    public static final String EXTRA_REPLAY = "com.example.android.booklistsql.REPLAY";
    private EditText mEditBookView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        mEditBookView = findViewById(R.id.edit_book);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(mEditBookView.getText())){
                setResult(RESULT_CANCELED,replyIntent);
            }else{
                String book = mEditBookView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLAY,book);
                setResult(RESULT_OK,replyIntent);
            }
            finish();
        });
    }
}