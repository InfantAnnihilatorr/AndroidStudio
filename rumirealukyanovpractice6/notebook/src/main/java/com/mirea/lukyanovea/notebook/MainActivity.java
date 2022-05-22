package com.mirea.lukyanovea.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText_main;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText_main = findViewById(R.id.editText2);
        preferences = getPreferences(MODE_PRIVATE);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                saveText();
                break;
            case R.id.button2:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(editText.getText().toString(), editText_main.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        String text = preferences.getString(editText.getText().toString(), "Empty");
        editText_main.setText(text);
    }
}