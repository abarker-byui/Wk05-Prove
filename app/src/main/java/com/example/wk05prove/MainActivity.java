package com.example.wk05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view) {
        EditText txtBook = (EditText)findViewById(R.id.editBook);
        EditText txtChapter = (EditText)findViewById(R.id.editChapter);
        EditText txtVerse = (EditText)findViewById(R.id.editVerse);

        String book = txtBook.getText().toString();
        int chapter = Integer.parseInt(txtChapter.getText().toString());
        int verse = Integer.parseInt(txtVerse.getText().toString());

        Log.d("Main", String.format("About to create intent with %s %d:%d", book, chapter, verse));

        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(getString(R.string.book_key), book);
        intent.putExtra(getString(R.string.chapter_key), chapter);
        intent.putExtra(getString(R.string.verse_key), verse);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        Log.d("Load", "Loading scripture");

        EditText txtBook = (EditText)findViewById(R.id.editBook);
        EditText txtChapter = (EditText)findViewById(R.id.editChapter);
        EditText txtVerse = (EditText)findViewById(R.id.editVerse);

        Context context = getBaseContext();
        SharedPreferences preferences = context.getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        String book = preferences.getString("BOOK", "");
        Integer chapter = preferences.getInt("CHAPTER", 0);
        Integer verse = preferences.getInt("VERSE", 0);

        if (book == "" || chapter.equals(0) || verse.equals(0))
        {
            Toast toast = Toast.makeText(context, R.string.load_failure, Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        txtBook.setText(book);
        txtChapter.setText(chapter.toString());
        txtVerse.setText(verse.toString());
    }
}
