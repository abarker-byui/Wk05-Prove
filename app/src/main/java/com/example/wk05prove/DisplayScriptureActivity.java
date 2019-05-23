package com.example.wk05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {
    private String _book;
    private int _chapter;
    private int _verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        Intent intent = getIntent();
        _book = intent.getStringExtra(getString(R.string.book_key));
        _chapter = intent.getIntExtra(getString(R.string.chapter_key), 0);
        _verse = intent.getIntExtra(getString(R.string.verse_key), 0);
        String scripture = String.format("%s %d:%d", _book, _chapter, _verse);

        Log.d("Display","Received intent with " + scripture);

        TextView viewScripture = findViewById(R.id.textViewScripture);
        viewScripture.setText(scripture);
    }

    public void saveScripture(View view) {
        String scripture = String.format("%s %d:%d", _book, _chapter, _verse);
        Log.d("Save", "Saving scripture " + scripture);

        Context context = getBaseContext();
        SharedPreferences preferences = context.getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor perfEditor = preferences.edit();
        perfEditor.putString("BOOK", _book);
        perfEditor.putInt("CHAPTER", _chapter);
        perfEditor.putInt("VERSE", _verse);
        perfEditor.apply();

        Toast successToast = Toast.makeText(context, getString(R.string.success_text), Toast.LENGTH_LONG);
        successToast.show();
    }
}
