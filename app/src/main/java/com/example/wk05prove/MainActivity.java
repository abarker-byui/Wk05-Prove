package com.example.wk05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.wk05prove.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view) {
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        EditText txtBook = (EditText)findViewById(R.id.editBook);
        EditText txtChapter = (EditText)findViewById(R.id.editChapter);
        EditText txtVerse = (EditText)findViewById(R.id.editVerse);
        String message = txtBook.getText().toString() + " " +
                txtChapter.getText().toString() + ":" +
                txtVerse.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
