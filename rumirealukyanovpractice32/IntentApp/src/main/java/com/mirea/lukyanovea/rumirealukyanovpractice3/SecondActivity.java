package com.mirea.lukyanovea.rumirealukyanovpractice3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        textView.setText(date);
    }
}
